package com.example.imsapi.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Nullable
    private User user;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }
}
