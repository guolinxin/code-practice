package com.guo.practice.codepractice.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcess {


    @Test
    public void readFile() throws IOException {

        // need full
        String fileUrl = "src/test/resources/file/testfile.txt";
        File file = new File(fileUrl);

        Path path = Path.of(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());

        // FileInputStream
        InputStream inputStream = new FileInputStream(file);
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        Assertions.assertNotNull(text);

        // Files class
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(lines);

    }


}
