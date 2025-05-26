package com.mycompany.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTestTest {

    private LoginTest loginTest;

    @BeforeEach
    public void setUp() {
        loginTest = new LoginTest();
    }

    @Test
    public void testValidUsername() {
        assertTrue(loginTest.checkUserName("user_01"), "Username with underscore and >=6 chars should be valid.");
    }

    @Test
    public void testInvalidUsername_NoUnderscore() {
        assertFalse(loginTest.checkUserName("user01"), "Username without underscore should be invalid.");
    }

    @Test
    public void testInvalidUsername_ShortLength() {
        assertFalse(loginTest.checkUserName("u_1"), "Username with less than 6 characters should be invalid.");
    }

    @Test
    public void testValidPassword() {
        assertTrue(loginTest.checkPasswordComplexity("Password1!"), "Password meeting all criteria should be valid.");
    }

    @Test
    public void testInvalidPassword_NoUppercase() {
        assertFalse(loginTest.checkPasswordComplexity("password1!"), "Password without uppercase letter should be invalid.");
    }

    @Test
    public void testInvalidPassword_NoNumber() {
        assertFalse(loginTest.checkPasswordComplexity("Password!"), "Password without number should be invalid.");
    }

    @Test
    public void testInvalidPassword_NoSpecialChar() {
        assertFalse(loginTest.checkPasswordComplexity("Password1"), "Password without special character should be invalid.");
    }

    @Test
    public void testValidCellPhoneNumber() {
        assertTrue(loginTest.checkCellPhoneNumber("+27123456789"), "Valid SA cellphone number should pass.");
    }

    @Test
    public void testInvalidCellPhoneNumber() {
        assertFalse(loginTest.checkCellPhoneNumber("0123456789"), "Cellphone number without +27 prefix should fail.");
    }

    @Test
    public void testUserRegistrationAndAuthentication() {
        String username = "user_01";
        String password = "Password1!";
        String cellphone = "+27123456789";
        String firstName = "John";
        String lastName = "Doe";

        loginTest.registerUser(username, password, cellphone, firstName, lastName);

        assertTrue(loginTest.isCorrectUsername(username), "Registered username should be recognized.");
        assertTrue(loginTest.isCorrectPassword(password), "Registered password should be recognized.");
    }

    @Test
    public void testAuthentication_IncorrectUsername() {
        String username = "user_01";
        String password = "Password1!";
        String cellphone = "+27123456789";
        String firstName = "John";
        String lastName = "Doe";

        loginTest.registerUser(username, password, cellphone, firstName, lastName);

        assertFalse(loginTest.isCorrectUsername("wrong_user"), "Incorrect username should not be recognized.");
    }

    @Test
    public void testAuthentication_IncorrectPassword() {
        String username = "user_01";
        String password = "Password1!";
        String cellphone = "+27123456789";
        String firstName = "John";
        String lastName = "Doe";

        loginTest.registerUser(username, password, cellphone, firstName, lastName);

        assertFalse(loginTest.isCorrectPassword("WrongPass1!"), "Incorrect password should not be recognized.");
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
