package com.mycompany.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTestTest {
    
    private LoginTest loginSystem;
    
    @BeforeEach
    public void setUp() {
        loginSystem = new LoginTest();
    }
    
    @Test
    public void testCheckUserNameValid() {
        assertTrue(loginSystem.checkUserName("user_name"));
        assertTrue(loginSystem.checkUserName("long_username"));
    }
    
    @Test
    public void testCheckUserNameInvalidNoUnderscore() {
        assertFalse(loginSystem.checkUserName("username"));
    }
    
    @Test
    public void testCheckUserNameInvalidTooShort() {
        assertFalse(loginSystem.checkUserName("a_b"));
    }
    
    @Test
    public void testCheckUserNameInvalidEmpty() {
        assertFalse(loginSystem.checkUserName(""));
    }
    
    @Test
    public void testCheckPasswordComplexityValid() {
        assertTrue(loginSystem.checkPasswordComplexity("Password1!"));
        assertTrue(loginSystem.checkPasswordComplexity("Complex@123"));
    }
    
    @Test
    public void testCheckPasswordComplexityNoCapital() {
        assertFalse(loginSystem.checkPasswordComplexity("password1!"));
    }
    
    @Test
    public void testCheckPasswordComplexityNoNumber() {
        assertFalse(loginSystem.checkPasswordComplexity("Password!"));
    }
    
    @Test
    public void testCheckPasswordComplexityNoSpecialChar() {
        assertFalse(loginSystem.checkPasswordComplexity("Password1"));
    }
    
    @Test
    public void testCheckPasswordComplexityTooShort() {
        assertFalse(loginSystem.checkPasswordComplexity("Pass1!"));
    }
    
    @Test
    public void testCheckCellPhoneNumberValid() {
        assertTrue(loginSystem.checkCellPhoneNumber("+27123456789"));
    }
    
    @Test
    public void testCheckCellPhoneNumberInvalidPrefix() {
        assertFalse(loginSystem.checkCellPhoneNumber("+28123456789"));
    }
    
    @Test
    public void testCheckCellPhoneNumberTooShort() {
        assertFalse(loginSystem.checkCellPhoneNumber("+27123456"));
    }
    
    @Test
    public void testCheckCellPhoneNumberTooLong() {
        assertFalse(loginSystem.checkCellPhoneNumber("+271234567890"));
    }
    
    @Test
    public void testCheckCellPhoneNumberNoPlus() {
        assertFalse(loginSystem.checkCellPhoneNumber("27123456789"));
    }
    
    @Test
    public void testRegisterAndLoginSuccess() {
        loginSystem.registerUser("test_user", "Password1!", "+27123456789", "John", "Doe");
        
        assertTrue(loginSystem.isCorrectUsername("test_user"));
        assertTrue(loginSystem.isCorrectPassword("Password1!"));
    }
    
    @Test
    public void testLoginBeforeRegistration() {
        assertFalse(loginSystem.isCorrectUsername("test_user"));
        assertFalse(loginSystem.isCorrectPassword("Password1!"));
    }
    
    @Test
    public void testLoginWrongCredentials() {
        loginSystem.registerUser("test_user", "Password1!", "+27123456789", "John", "Doe");
        
        assertFalse(loginSystem.isCorrectUsername("wrong_user"));
        assertFalse(loginSystem.isCorrectPassword("WrongPass1!"));
    }
    
    @Test
    public void testMessageHandlerCreateMessageId() {
        LoginTest.MessageHandler handler = new LoginTest.MessageHandler();
        String messageId = handler.createMessageId();
        
        assertNotNull(messageId);
        assertTrue(messageId.matches("\\d+"));
    }
    
    @Test
    public void testMessageHandlerCreateMessageHash() {
        LoginTest.MessageHandler handler = new LoginTest.MessageHandler();
        String hash = handler.createMessageHash("123456789", "Hello world");
        
        assertNotNull(hash);
        assertEquals("12:12:HELLO", hash);
    }
    
    @Test
    public void testMessageHandlerCreateMessageHashEmpty() {
        LoginTest.MessageHandler handler = new LoginTest.MessageHandler();
        String hash = handler.createMessageHash("123456789", "");
        
        assertNotNull(hash);
        assertEquals("12:12:EMPTY", hash);
    }
}