package com.ecrops.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+{}|[]\\;:'\"<>,.?/~";

    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String password = (String) target;

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            errors.rejectValue("password", "password.length", "Password must be at least 8 characters long");
            System.out.println( "Password must be at least 8 characters long");
        }

        // Check if password contains at least one alphabet
        if (!password.matches(".*[a-zA-Z].*")) {
            errors.rejectValue("password", "password.alphabet", "Password must contain at least one alphabet");
            System.out.println( "Password must contain at least one alphabet");

        }

        // Check if password contains at least one special character
        if (!containsSpecialCharacter(password)) {
            errors.rejectValue("password", "password.special", "Password must contain at least one special character");
            System.out.println("Password must contain at least one special character");

        }
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : SPECIAL_CHARACTERS.toCharArray()) {
            if (password.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }
}
