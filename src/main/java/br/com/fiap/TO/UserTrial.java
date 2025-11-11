package br.com.fiap.TO;

import java.time.LocalDate;

public class UserTrial {
    //atributos
    private Long idUser;
    private Long idTrial;
    private LocalDate startDate;
    private int progressPercentage;
    private String status;

    //setters e getters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(Long idTrial) {
        this.idTrial = idTrial;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
