package com.defalut.fsmanager;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUtils {

    public static void copyFile(File source, File destinationDirectory) throws IOException {
        if (!source.isFile()) {
            throw new IllegalArgumentException("Источник не является файлом");
        }

        if (!destinationDirectory.isDirectory()) {
            throw new IllegalArgumentException("Назначение не является директорией");
        }

        File destinationFile = new File(destinationDirectory, source.getName());
        Files.copy(source.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
