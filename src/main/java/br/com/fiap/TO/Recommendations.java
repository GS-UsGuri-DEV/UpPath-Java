package br.com.fiap.TO;

import java.time.LocalDate;

public class Recommendations {
    //atributos
    private Long idRecommendation;
    private Long idUser;
    private String type;
    private Long idReference;
    private String message;
    private LocalDate dateRecommendation;

    //setters e getters
    public Long getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(Long idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdReference() {
        return idReference;
    }

    public void setIdReference(Long idReference) {
        this.idReference = idReference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateRecommendation() {
        return dateRecommendation;
    }

    public void setDateRecommendation(LocalDate dateRecommendation) {
        this.dateRecommendation = dateRecommendation;
    }
}
