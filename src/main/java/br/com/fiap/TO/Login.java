package br.com.fiap.TO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class Login {
    @NotBlank
    private String cpf;
    @NotBlank
    private LocalDate password;

    //setter e getter

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getPassword() {
        return password;
    }

    public void setPassword(LocalDate password) {
        this.password = password;
    }
}
