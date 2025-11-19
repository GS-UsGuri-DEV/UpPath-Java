package br.com.fiap.TO;

import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public class User {
    //atributos
    private Long idUser;
    private Long idEmpresa;
    private String name;
    @Email
    private String email;
    private String password;
    private String nivelCarreira;
    private String occupation;
    private String gender;
    private LocalDate birthDate;
    private LocalDate dateRegistered;
    private Long admin;

    //setters e getters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getNivelCarreira() {
        return nivelCarreira;
    }

    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Long getAdmin() {
        return admin;
    }

    public void setAdmin(Long admin) {
        this.admin = admin;
    }


    //metodos

}
