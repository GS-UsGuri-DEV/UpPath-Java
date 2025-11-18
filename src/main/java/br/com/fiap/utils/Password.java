package br.com.fiap.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Password {
    public static String valid(String password) {

        if (password == null || password.length() < 8) {
            return null;
        }

        boolean uppercase = false, lowercase = false, number = false, special = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) uppercase = true;
            else if (Character.isLowerCase(c)) lowercase = true;
            else if (Character.isDigit(c)) number = true;
            else special = true;
        }

        if (!(uppercase && lowercase && number && special)) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            return HexFormat.of().formatHex(hashBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha", e);
        }
    }

}
