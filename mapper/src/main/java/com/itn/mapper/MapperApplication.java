package com.itn.mapper;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.*;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@SpringBootApplication
public class MapperApplication {

    private static final String INBOUND_PATH = "c:/dev/files";

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
        source.setDirectory(new File(INBOUND_PATH));
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        source.setWatchEvents(FileReadingMessageSource.WatchEventType.CREATE);
        return source;
    }

    @Bean
    public IntegrationFlow fileReadingFlow() {
        return IntegrationFlows.from(Files.inboundAdapter(new File("c:/dev/files")).
                patternFilter("*.txt").
                useWatchService(true).
                watchEvents(FileReadingMessageSource.WatchEventType.CREATE, FileReadingMessageSource.WatchEventType.MODIFY),
                e -> e.poller(Pollers.fixedDelay(100).errorChannel("filePollingErrorChannel"))).filter(File.class, p -> !p.getName().startsWith("a"), e -> e.throwExceptionOnRejection(true)).transform(Files.toStringTransformer()).aggregate(a -> a.correlationExpression("1").releaseStrategy(g -> g.size() == 25)).channel(MessageChannels.queue("fileReadingResultChannel")).get();
    }

}

