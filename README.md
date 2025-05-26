# Login System Documentation

## Overview

This Java application provides a user registration and login system with validation for usernames, passwords, and South African cellphone numbers. The system ensures secure registration and authentication processes.

## Features

* **User Registration**:

  * Validates username format (must contain '\_' and be at least 6 characters)
  * Validates password complexity (≥8 characters, 1 capital letter, 1 number, 1 special character)
  * Validates South African cellphone format (+27 followed by 9 digits)
  * Stores first and last name

* **User Login**:

  * Authenticates users against registered credentials
  * Provides multiple attempts for failed logins
  * Displays personalized welcome message upon successful login

* **Unit Testing**:

  * JUnit test cases for username, password, and cellphone validations
  * Includes both valid and invalid test scenarios
  * Demonstrates practical knowledge of test-driven development

## Code Structure

The system consists of two main classes:

1. **Login.java** - Contains the main application logic and user interface
2. **LoginTest.java** - Handles validation, registration, and authentication logic
3. **LoginTestTest.java** - Contains JUnit test cases for LoginTest.java methods

## Validation Rules

| Field     | Validation Rule                                                             |
| --------- | --------------------------------------------------------------------------- |
| Username  | Must contain '\_' and be at least 6 characters (e.g., "user\_1")            |
| Password  | ≥8 characters, at least 1 capital letter, 1 number, and 1 special character |
| Cellphone | Must start with +27 followed by exactly 9 digits (e.g., +27821234567)       |

## How to Use

1. Run the `Login` class
2. Follow the registration prompts:

   * Enter a valid username
   * Create a secure password
   * Provide a valid South African cellphone number
   * Enter your first and last name
3. After successful registration, log in with your credentials
4. You'll receive a personalized welcome message upon successful login
5. Run the `LoginTestTest` class to validate the code with JUnit tests

## Technical Details

* Uses regular expressions for pattern matching
* Implements input validation with informative error messages
* Stores user data in memory
* Follows secure password practices
* Uses JUnit for automated unit testing

## References

The Independent Institute of Education (IIE), 2019. Java Programming: Creating Java Programs \[Chapter 1 PowerPoint]. \[online via internal VLE]. The Independent Institute of Education. Available at: \<Chapter 1 - Creating Java Programs.pptx> \[Accessed 18 April 2025].

The Independent Institute of Education (IIE), 2019. Java Programming: Using Data \[Chapter 2 PowerPoint]. \[online via internal VLE]. The Independent Institute of Education. Available at: \<Chapter 2.pptx> \[Accessed 18 April 2025].

The Independent Institute of Education (IIE), 2019. Java Programming: Using Methods, Classes, and Objects \[Chapter 3 PowerPoint]. \[online via internal VLE]. The Independent Institute of Education. Available at: \<Chapter 3.pptx> \[Accessed 18 April 2025].

Chegg, 2020. How to Cite a YouTube Video in APA Style | Chegg. \[video online] Available at: [https://www.youtube.com/watch?v=p8bZBvcFPuk](https://www.youtube.com/watch?v=p8bZBvcFPuk) \[Accessed 22 April 2025].

GitHub Docs, 2021. Create a repository. \[online] GitHub. Available at: [https://docs.github.com/en/get-started/quickstart/create-a-repo](https://docs.github.com/en/get-started/quickstart/create-a-repo) \[Accessed 23 April 2025].

GitHub Education, 2022. GitHub Student Developer Pack. \[online] Available at: [https://education.github.com/pack](https://education.github.com/pack) \[Accessed 23 April 2025].

GitHub Classroom, 2022. GitHub Organization Invite Guide. \[online] Available at: [https://docs.idalko.com/exalate/display/ED/Accept+an+invitation+in+Exalate+for+GitHub](https://docs.idalko.com/exalate/display/ED/Accept+an+invitation+in+Exalate+for+GitHub) \[Accessed 23 April 2025].

FreeCodeCamp, 2023. JUnit Java Testing Tutorial for Beginners. \[video online] Available at: [https://www.youtube.com/playlist?list=PL480DYS-b\_kHSYf2yLqto\_mwDr\_U-Q06](https://www.youtube.com/playlist?list=PL480DYS-b_kHSYf2yLqto_mwDr_U-Q06) \[Accessed 25 April 2025].
