package br.com.fiap.TO;

import jakarta.validation.constraints.NotBlank;

public class Login {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    //setter e getter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //metodos
    public static boolean validaSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean maiuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        boolean especial = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) maiuscula = true;
            else if (Character.isLowerCase(c)) minuscula = true;
            else if (Character.isDigit(c)) numero = true;
            else especial = true;
        }

        return maiuscula && minuscula && numero && especial;
    }
}
