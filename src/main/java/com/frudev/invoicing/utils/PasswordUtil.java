package com.frudev.invoicing.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public static boolean check(String plainText, String hashedPassword) {
        return encoder.matches(plainText, hashedPassword);
    }

    public static String encode(String plainText) {
        return encoder.encode(plainText);
    }
}
