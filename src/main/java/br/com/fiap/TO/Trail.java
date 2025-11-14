package br.com.fiap.TO;

import java.time.LocalDate;

public class Trail {
    //atributos
    private Long idTrial;
    private String title;
    private String description;

    private byte[] image;
    private String imageName;
    private String imageMime;
    private int imageSize;
    private String imageAlt;
    private byte[] imageThumb;

    private String category;
    private String difficultyLevel;
    private LocalDate creationDate;

    //setters e getters
    public Long getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(Long idTrial) {
        this.idTrial = idTrial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageMime() {
        return imageMime;
    }

    public void setImageMime(String imageMime) {
        this.imageMime = imageMime;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public byte[] getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(byte[] imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    //medtodos
}
