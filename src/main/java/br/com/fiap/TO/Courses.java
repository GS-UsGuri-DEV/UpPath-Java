package br.com.fiap.TO;

public class Courses {
    //atributos
    private Long idCourse;
    private Long idTrial;
    private String courseName;
    private String description;
    private byte[] imgCourse;
    private String imgCourseName;
    private String imgCourseMime;
    private int imgCourseSize;
    private String imgCourseAlt;
    private byte[] imgCourseThumb;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImgCourse() {
        return imgCourse;
    }

    public void setImgCourse(byte[] imgCourse) {
        this.imgCourse = imgCourse;
    }

    public String getImgCourseName() {
        return imgCourseName;
    }

    public void setImgCourseName(String imgCourseName) {
        this.imgCourseName = imgCourseName;
    }

    public String getImgCourseMime() {
        return imgCourseMime;
    }

    public void setImgCourseMime(String imgCourseMime) {
        this.imgCourseMime = imgCourseMime;
    }

    public int getImgCourseSize() {
        return imgCourseSize;
    }

    public void setImgCourseSize(int imgCourseSize) {
        this.imgCourseSize = imgCourseSize;
    }

    public String getImgCourseAlt() {
        return imgCourseAlt;
    }

    public void setImgCourseAlt(String imgCourseAlt) {
        this.imgCourseAlt = imgCourseAlt;
    }

    public byte[] getImgCourseThumb() {
        return imgCourseThumb;
    }

    public void setImgCourseThumb(byte[] imgCourseThumb) {
        this.imgCourseThumb = imgCourseThumb;
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
