package br.com.fiap.TO;

import java.time.LocalDate;

public class WellBeing {
    //atributos
    private Long idWellBeing;
    private Long idUser;
    private LocalDate dateRecorded;
    private int stressLevel;
    private int motivationLevel;
    private int sleepQuality;
    private String observations;

    //setters e getters
    public Long getIdWellBeing() {
        return idWellBeing;
    }

    public void setIdWellBeing(Long idWellBeing) {
        this.idWellBeing = idWellBeing;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(LocalDate dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public int getMotivationLevel() {
        return motivationLevel;
    }

    public void setMotivationLevel(int motivationLevel) {
        this.motivationLevel = motivationLevel;
    }

    public int getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(int sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    //metodos
}
