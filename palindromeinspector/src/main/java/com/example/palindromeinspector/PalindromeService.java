package com.example.palindromeinspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PalindromeService {

    @Autowired
    private PalindromeValidator palindromeValidator;

    @Autowired
    private PalindromeFile persistenceService;

    @Cacheable("palindromes")
    public PalindromeResponse checkPalindrome(PalindromeRequest request) {
        if (!palindromeValidator.isValid(request.getText())) {
            return new PalindromeResponse(false, "Invalid input");
        }

        boolean isPalindrome = isPalindrome(request.getText());

        persistenceService.persist(request.getText(), isPalindrome);

        return new PalindromeResponse(isPalindrome, null);
    }

    private boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public List<String> getCachedValues() {
        Path filePath = Path.of("palindromes.txt");

        try {
            return Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}