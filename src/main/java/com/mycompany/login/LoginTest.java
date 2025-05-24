package com.mycompany.login;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginTest {
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    private boolean isRegistered = false;

    private static final String CELL_PHONE_REGEX = "^\\+27\\d{9}$";
    private static final String USERNAME_REGEX = "^(?=.*_).{6,}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public boolean checkUserName(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    public boolean checkPasswordComplexity(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        return Pattern.matches(CELL_PHONE_REGEX, cellNumber);
    }

    public void registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isRegistered = true;
    }

    public boolean isCorrectUsername(String enteredUsername) {
        return isRegistered && enteredUsername.equals(username);
    }

    public boolean isCorrectPassword(String enteredPassword) {
        return isRegistered && enteredPassword.equals(password);
    }

    static class MessageHandler {
        private int messageCount = 0;

        public void sendMessages(Scanner scanner) {
            while (true) {
                System.out.print("Enter message (type 'exit' to quit): ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                if (message.length() > 250) {
                    System.out.println("Message exceeds 250 characters. Please shorten it.");
                    continue;
                }

                String messageId = createMessageId();
                String messageHash = createMessageHash(messageId, message);

                System.out.println("Message sent!");
                System.out.println("Message ID: " + messageId);
                System.out.println("Message Hash: " + messageHash);
                messageCount++;
            }

            System.out.println("Total messages sent: " + messageCount);
        }

        private String createMessageId() {
            return String.valueOf((int) (Math.random() * 1_000_000_000));
        }

        private String createMessageHash(String messageId, String message) {
            String prefix = messageId.substring(0, 2);
            String firstWord = message.isEmpty() ? "EMPTY" : message.split(" ")[0].toUpperCase();
            return prefix + ":" + prefix + ":" + firstWord;
        }
    }
}