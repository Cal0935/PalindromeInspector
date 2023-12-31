package com.example.palindromeinspector;

import java.time.LocalDateTime;

public class PalindromeRequest {
    
    private String username;
    private String text;
    private LocalDateTime dateTime;

    public PalindromeRequest(String username, String text, LocalDateTime dateTime) {
        this.username = username;
        this.text = text;
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
