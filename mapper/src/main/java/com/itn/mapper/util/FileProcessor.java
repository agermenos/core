package com.itn.mapper.util;

import com.itn.mapper.dao.LineItemDefinitionRepository;
import com.itn.mapper.dao.LineItemRepository;
import com.itn.mapper.model.LineItem;
import com.itn.mapper.model.LineItemDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component("fileProcessor")
public class FileProcessor {
    private static final Integer STATUS_OK = 1;
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDefinitionRepository lineItemDefinitionRepository;

    private Map<Integer, List<LineItemDefinition>> currentDefinitions = new HashMap<>();
    private static final String BASIC_PATH = "C:/dev/files";
    private static final String INBOUND_PATH = "/input";
    private static final String OUTBOUND_PATH= "/output";

    private static final String HEADER_FILE_NAME = "file_name";
    private static final String MSG = "%s received. Content: %s";

    public void process(Message<String> msg) {
        String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
        UUID uuid = UUID.randomUUID();
        String randomUUID = uuid.toString();
        String content = msg.getPayload();
        String[] lines = content.split("\r\n");
        String[] header = lines[1].split("\\|");
        Integer key = Integer.parseInt(header[1]);
        //List<LineItemDefinition> lineItemDefinitions = getLineItemDefinition(lines[1], key);
        Arrays.stream(lines).skip(2).forEach(line -> {
                String type = line.substring(0,2);
                if (line.length()>15 && type.equals("II"))
                lineItemRepository.save(LineItem.builder()
                    .tenantId(key)
                    .content(line)
                    .status(STATUS_OK)
                    .invoiceId(randomUUID)
                    .build());
        });
        System.out.println(String.format(MSG, fileName, content));
        moveFile(msg);
    }

    private List<LineItemDefinition> getLineItemDefinition(String line, Integer key) {
        if (currentDefinitions.containsKey(key)) return currentDefinitions.get(key);
        else {
            List<LineItemDefinition> lineItemDefinitions = lineItemDefinitionRepository.findAllByTenantIdOrderByIdx(key);
            currentDefinitions.put(key, lineItemDefinitions);
            return lineItemDefinitions;
        }
    }

    public void moveFile(Message<String> msg){
        File file = msg.getHeaders().get(FileHeaders.ORIGINAL_FILE, File.class);
        file.renameTo(new File(BASIC_PATH+OUTBOUND_PATH, file.getName()));
        System.out.println("File renamed after success");
    }
}
