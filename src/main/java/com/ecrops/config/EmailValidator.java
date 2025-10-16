package com.ecrops.config;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        // Check for a single @ symbol
        long atCount = email.chars().filter(ch -> ch == '@').count();
        if (atCount != 1) {
            return false;
        }

        // Validate the email structure
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
    
    public static boolean isValidString(String input) {
        if (input == null) {
            return false;
        }

        // Check for the presence of a comma
        return !input.contains(",");
    }
}