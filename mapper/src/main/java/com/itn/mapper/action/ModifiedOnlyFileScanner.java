package com.itn.mapper.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.context.Lifecycle;
import org.springframework.integration.file.DefaultDirectoryScanner;
import org.springframework.util.Assert;
public class ModifiedOnlyFileScanner { // extends DefaultDirectoryScanner implements Lifecycle {


//    private final ConcurrentMap<Path, WatchKey> pathKeys = new ConcurrentHashMap<>();
//
//    private WatchService watcher;
//
////	private Collection<File> initialFiles;
//
//    private WatchEvent.Kind<?>[] kinds;
//
//    private File directory;
//
//    @Override
//    public void start() {
//        try {
//            this.watcher = FileSystems.getDefault().newWatchService();
//        }
//        catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        this.kinds = new WatchEvent.Kind<?>[]{StandardWatchEventKinds.ENTRY_MODIFY};
//        walkDirectory(directory.toPath(), null);
////		final Set<File> initialFiles = ;
////		initialFiles.addAll(filesFromEvents());
////		this.initialFiles = initialFiles;
//    }
//
//    public ModifiedOnlyFileScanner(File directory) {
//        super();
//        this.directory = directory;
//    }
//
//    @Override
//    public void stop() {
//        try {
//            this.watcher.close();
//            this.watcher = null;
//            this.pathKeys.clear();
//        }
//        catch (IOException e) {
//            System.err.println("Failed to close watcher for " + directory+ " "+e.getMessage());
//        }
//    }
//
//    @Override
//    public boolean isRunning() {
//        return true;
//    }
//
//    @Override
//    protected File[] listEligibleFiles(File directory) {
//        Assert.state(this.watcher != null, "The WatchService has'nt been started");
//        Collection<File> files = filesFromEvents();
//        if(files.size()>0){
//            System.err.println("Detected Modified files "+files);
//        }
//        return files.toArray(new File[files.size()]);
//    }
//
//    private Set<File> filesFromEvents() {
//        WatchKey key = this.watcher.poll();
//        Set<File> files = new LinkedHashSet<>();
//        while (key != null) {
//            File parentDir = ((Path) key.watchable()).toAbsolutePath().toFile();
//            for (WatchEvent<?> event : key.pollEvents()) {
//                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY ) {
//                    Path item = (Path) event.context();
//                    File file = new File(parentDir, item.toFile().getName());
//                    if (file.exists()) {
//                        //I do not dig into directories
//                        if (!file.isDirectory()) {
//                            files.remove(file);
//                            files.add(file);
//                        }
//                    }
//                    else {
//                        System.err.println("A file [" + file + "] for the event [" + event.kind() +
//                                "] doesn't exist. Ignored.");
//                    }
//                }
//            }
//            key.reset();
//            key = this.watcher.poll();
//        }
//        return files;
//    }
//
//    private Set<File> walkDirectory(Path directory, final WatchEvent.Kind<?> kind) {
//        final Set<File> walkedFiles = new LinkedHashSet<>();
//        try {
//            registerWatch(directory);
//            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
//
//                @Override
//                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//                    FileVisitResult fileVisitResult = super.preVisitDirectory(dir, attrs);
//                    registerWatch(dir);
//                    return fileVisitResult;
//                }
//
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    FileVisitResult fileVisitResult = super.visitFile(file, attrs);
//                    if (!StandardWatchEventKinds.ENTRY_MODIFY.equals(kind)) {
//                        walkedFiles.add(file.toFile());
//                    }
//                    return fileVisitResult;
//                }
//
//            });
//        }
//        catch (IOException e) {
//            System.err.println("Failed to walk directory: " + directory.toString()+" "+ e.getMessage());
//        }
//        return walkedFiles;
//    }
//
//    private void registerWatch(Path dir) throws IOException {
//        if (!this.pathKeys.containsKey(dir)) {
//            System.out.println("registering: " + dir + " for file events");
//            WatchKey watchKey = dir.register(this.watcher, this.kinds);
//            this.pathKeys.putIfAbsent(dir, watchKey);
//        }
//    }
}
