package com.example.palindromeinspector;


import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeFile {

    private static final String FILE_PATH = "palindromes.txt";

    public void persist(String text, boolean isPalindrome) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(text + "," + isPalindrome + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> loadPersistedValues() {
        try {
            return Files.lines(Paths.get(FILE_PATH))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}