package com.mycompany.login;

import com.mycompany.login.LoginTest.MessageHandler;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LoginTest loginSystem = new LoginTest();

            System.out.println("REGISTRATION");

            String username;
            while (true) {
                System.out.print("Username (must contain '_' and be at least 6 characters): ");
                username = scanner.nextLine();
                if (loginSystem.checkUserName(username)) {
                    break;
                }
                System.out.println("Invalid username. It must contain an underscore and be at least 6 characters.");
            }

            String password;
            while (true) {
                System.out.print("Password (min 8 chars, 1 capital, 1 number, 1 special char): ");
                password = scanner.nextLine();
                if (loginSystem.checkPasswordComplexity(password)) {
                    break;
                }
                System.out.println("Invalid password. Must contain at least 8 characters, a capital letter, a number, and a special character.");
            }

            String cellphone;
            while (true) {
                System.out.print("SA Cellphone Number (+27 followed by 9 digits): ");
                cellphone = scanner.nextLine();
                if (loginSystem.checkCellPhoneNumber(cellphone)) {
                    break;
                }
                System.out.println("Invalid phone number. Must begin with +27 followed by exactly 9 digits.");
            }

            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            loginSystem.registerUser(username, password, cellphone, firstName, lastName);
            System.out.println("Registration successful!");
            
            System.out.println("\n=== LOGIN ===");
            boolean loginSuccess = false;
            for (int attempts = 0; attempts < 3 && !loginSuccess; attempts++) {
                System.out.print("Username: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Password: ");
                String loginPassword = scanner.nextLine();

                boolean correctUsername = loginSystem.isCorrectUsername(loginUsername);
                boolean correctPassword = loginSystem.isCorrectPassword(loginPassword);

                if (correctUsername && correctPassword) {
                    loginSuccess = true;
                    break;
                }

                if (!correctUsername && !correctPassword) {
                    System.out.println("Both username and password are incorrect. Please try again.");
                } else if (!correctUsername) {
                    System.out.println("Username is incorrect. Please try again.");
                } else {
                    System.out.println("Password is incorrect. Please try again.");
                }
            }

            if (loginSuccess) {
                System.out.println("Welcome back, " + firstName + "!");
                MessageHandler messageHandler = new MessageHandler();
                messageHandler.sendMessages(scanner);
            } else {
                System.out.println("Too many failed login attempts.");
            }
        }
    }
    
        private static void displayWelcomeMessage() {
        String welcomeMessage = "Welcome to the ChatApp!\nPlease register to continue.";
        JOptionPane.showMessageDialog(null, welcomeMessage);
    }
}