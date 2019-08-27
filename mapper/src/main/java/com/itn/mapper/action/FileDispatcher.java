package com.itn.mapper.action;

import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.file.FileReadingMessageSource;

import java.io.File;
import java.util.concurrent.TimeUnit;

@EnableIntegration
public class FileDispatcher {
//
//
//    public FileDispatcher(String readindDir) {
//        super();
//        this.readingDir=readindDir;
//
//    }
//
//    public static final String REPLY_CHANNEL_SUFFIX = "%s_replayChannel";
//    private static final String SOURCE_MODIFIED_SUFFIX = "%s_source_modified";
//    private static final String SOURCE_FLOW_MODIFIED_SUFFIX = "%s_source_flow_modified";
//
//    private final String readingDir;
//
//
//    public void initDispatcher(IntegrationFlowContext intContext) throws Exception {
//        IntegrationFlow sourceModifiedFlow = IntegrationFlows
//                .from(this.getFileModifiedMessageSource(), s -> s.poller(Pollers.fixedRate(100, TimeUnit.MILLISECONDS)))
//                .handle(p -> {
//                    String fileName =((File)p.getPayload()).getName();
//                    System.out.println(fileName+" MODIFIED!");
//                }).get();
//
//        intContext.registration(sourceModifiedFlow).id(String.format(SOURCE_FLOW_MODIFIED_SUFFIX, "sourceFlow")).autoStartup(true).register();
//    }
//
//
//
//
//    public FileReadingMessageSource getFileModifiedMessageSource() {
//        FileReadingMessageSource lm = new FileReadingMessageSource();
//        lm.setBeanName(String.format(SOURCE_MODIFIED_SUFFIX, "fileSource"));
//        lm.setDirectory(new File(readingDir));
//        ModifiedOnlyFileScanner modifiedOnlyFileScanner = new ModifiedOnlyFileScanner(new File(readingDir));
//        lm.setScanner(modifiedOnlyFileScanner);
//
//        return lm;
//    }
}
