package com.example.palindromeinspector;

import java.time.LocalDateTime;

public class PalindromeResponse {

    private String username;
    private String text;
    private boolean isPalindrome;
    private LocalDateTime timestamp;

    public PalindromeResponse(boolean isPalindrome, String username, String timestamp) {
        this.isPalindrome = isPalindrome;
        this.username = username;
        this.timestamp = LocalDateTime.parse(timestamp);
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
