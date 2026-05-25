package com.mycompany.chatapp1;

import java.util.regex.Pattern;

public class Login {

    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    // Default constructor
    public Login() {
        // You can leave this empty or initialize default values if needed
    }

    // Constructor with firstName and lastName
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // USERNAME VALIDATION
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5 && username.length() > 2;
    }

    public String registerUsername(String username) {
        if (checkUserName(username)) {
            this.username = username;
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    // PASSWORD VALIDATION
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }

    public String registerPassword(String password) {
        if (checkPasswordComplexity(password)) {
            this.password = password;
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    // PHONE NUMBER VALIDATION
    public boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, phoneNumber);
    }

    public String registerCellPhoneNumber(String phoneNumber) {
        if (checkCellPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
    }

    // LOGIN VALIDATION
    public boolean loginUser(String username, String password) {
        if (this.username == null || this.password == null) {
            return false; // If no username/password are set, login should fail
        }
        return this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }
}