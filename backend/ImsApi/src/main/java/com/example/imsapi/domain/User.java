package com.example.imsapi.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Image> images;

    public User() {
    }

    private User(UserBuilder builder) {
        setId(builder.id);
        setUsername(builder.username);
        setPassword(builder.password);
        setImages(builder.images);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class UserBuilder {
        private Long id;

        private String username;

        private String password;
        private Set<Image> images;


        public UserBuilder(){}
        public UserBuilder(User copy) {
            this.id = copy.getId();
            this.username = copy.getUsername();
            this.password = copy.getPassword();
            this.images = copy.getImages();
        }

        public UserBuilder id(Long val) {
            this.id = val;
            return this;
        }

        public UserBuilder username(String val) {
            this.username = val;
            return this;
        }

        public UserBuilder password(String val) {
            this.password = val;
            return this;
        }

        public UserBuilder images(Set<Image> val) {
            this.images = val;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
