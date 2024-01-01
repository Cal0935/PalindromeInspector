package com.example.palindromeinspector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PalindromeServiceTests {

    @Mock
    private PalindromeValidator palindromeValidator;

    @Mock
    private PalindromeFile persistenceService;

    @InjectMocks
    private PalindromeService palindromeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCheckPalindrome_ValidPalindrome() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest("john_doe", "madam", LocalDateTime.now());
        when(palindromeValidator.isValid("madam")).thenReturn(true);

        // Act
        PalindromeResponse response = palindromeService.checkPalindrome(request);

        // Assert
        assertTrue(response.isPalindrome());
        assertEquals("john_doe", response.getUsername());
        assertNotNull(response.getTimestamp());
        verify(persistenceService).persist(eq("john_doe"), eq("madam"), eq(true), any(LocalDateTime.class));
    }

    @Test
    public void testCheckPalindrome_InvalidInput() {
        // Arrange
        PalindromeRequest request = new PalindromeRequest("john_doe", "12345", LocalDateTime.now());
        when(palindromeValidator.isValid("12345")).thenReturn(false);

        // Act
        PalindromeResponse response = palindromeService.checkPalindrome(request);

        // Assert
        assertFalse(response.isPalindrome());
        assertEquals("Invalid input", response.getText());
        assertNull(response.getUsername());
        assertNull(response.getTimestamp());
        verify(persistenceService, never()).persist(anyString(), anyString(), anyBoolean(), any(LocalDateTime.class));
    }

}