package com.example.palindromeinspector;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeFile {

    private static final String FILE_PATH = "palindromes.txt";
    private static final String HEADER = "Username,Text,IsPalindrome,Timestamp";

    public void persist(String username, String text, boolean isPalindrome, LocalDateTime timestamp) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            if (Files.size(Paths.get(FILE_PATH)) == 0) {
                writer.write(HEADER + System.lineSeparator());
            }

            // Format the data as CSV and append it to the file
            String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("HH-mm-ss, dd-MM-yyyy"));
            String data = String.format("%s,%s,%s,%s%n",
                    username, text, isPalindrome, formattedTimestamp);
            writer.write(data);
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
