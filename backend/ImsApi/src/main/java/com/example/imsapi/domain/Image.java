package com.example.imsapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser(){
        return user;
    }
}
