package com.example.palindromeinspector;
import org.springframework.stereotype.Component;

@Component
public class PalindromeValidator {

    public boolean isValid(String text) {

        return !text.matches(".*[0-9\\s\\p{Punct}].*");
    }
}