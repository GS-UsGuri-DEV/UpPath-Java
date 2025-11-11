package br.com.fiap.TO;

public class Courses {
    //atributos
    private Long idCourse;
    private Long idTrial;
    private String courseName;
    private String platform;
    private String url;
    private int durationHours;

    //setters e getters
    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Long getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(Long idTrial) {
        this.idTrial = idTrial;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    //metodo
}
