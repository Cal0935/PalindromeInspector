package com.example.palindromeinspector;

public class PalindromeResponse {

    private boolean isPalindrome;
    private String message;

    public PalindromeResponse(boolean isPalindrome, String message) {
        this.isPalindrome = isPalindrome;
        this.message = message;
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}