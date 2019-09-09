package com.itn.mapper;

import com.itn.mapper.util.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@SpringBootApplication
public class MapperApplication {

    private static final String BASIC_PATH = "c:/dev/files";
    private static final String INBOUND_PATH = "/input";

    @Autowired
    FileProcessor fileProcessor;

    public static void main(String[] args) {
        new SpringApplicationBuilder(MapperApplication.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File(BASIC_PATH + INBOUND_PATH));
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        source.setWatchEvents(FileReadingMessageSource.WatchEventType.CREATE);
        return source;
    }

    @Bean
    @Transformer(inputChannel = "fileInputChannel", outputChannel = "processFileChannel")
    public FileToStringTransformer fileToStringTransformer() {
        return new FileToStringTransformer();
    }

    @Bean
    public IntegrationFlow processFileFlow() {
        return IntegrationFlows
                .from("fileInputChannel")
                .transform(fileToStringTransformer())
                .handle("fileProcessor", "process").get();
    }
}

