package com.example.palindromeinspector;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PalindromeRequest {
    
    private String username;
    private String text;
    private String dateTime;

    public PalindromeRequest() {
    }

    public PalindromeRequest(String username, String text, LocalDateTime dateTime) {
        this.username = username;
        this.text = text;
        this.dateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
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
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
