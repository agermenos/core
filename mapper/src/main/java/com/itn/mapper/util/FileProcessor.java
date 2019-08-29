package com.itn.mapper.util;

import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;

@Component("fileProcessor")
public class FileProcessor {
    private static final String BASIC_PATH = "c:/dev/files";
    private static final String INBOUND_PATH = "/input";
    private static final String OUTBOUND_PATH= "/output";

    private static final String HEADER_FILE_NAME = "file_name";
    private static final String MSG = "%s received. Content: %s";

    public void process(Message<String> msg) {
        String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
        String content = msg.getPayload();
        String[] lines = content.split("\r\n");
        System.out.println(String.format(MSG, fileName, content));
        moveFile(msg);
    }

    public void moveFile(Message<String> msg){
        File file = msg.getHeaders().get(FileHeaders.ORIGINAL_FILE, File.class);
        file.renameTo(new File(BASIC_PATH+OUTBOUND_PATH, file.getName()));
        System.out.println("File renamed after success");
    }
}
