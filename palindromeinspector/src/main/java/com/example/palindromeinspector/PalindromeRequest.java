package com.example.palindromeinspector;

public class PalindromeRequest {

    private String text;

    public PalindromeRequest() {
    }

    public PalindromeRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
