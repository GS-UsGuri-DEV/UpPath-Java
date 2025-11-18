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

}
