package com.example.imsapi.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {

    private String title;

    private MultipartFile image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
