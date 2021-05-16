package ru.netcracker.tasks.se.nio2;

import java.io.IOException;
import java.nio.file.*;

public class SelfOutput {
    private static final String SRC_DIRECTORY = "/src/ru/netcracker/tasks/se/nio2";
    private Path directory;

    public void setWorkingDirectoryPath() {
        directory = Paths.get(System.getProperty("user.dir"));
    }

    public void setSrcPath() {
        directory = Paths.get(Paths.get(System.getProperty("user.dir")) + SRC_DIRECTORY);
    }

    public Path getPath() {
        return directory;
    }

    public void copyJavaFile() throws IOException {
        directory = Paths.get(Paths.get(System.getProperty("user.dir")) + SRC_DIRECTORY + "/SelfOutput.java");
        Files.copy(directory, Paths.get("SelfOutput.java"));
    }
}