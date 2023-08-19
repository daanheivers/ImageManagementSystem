package com.example.imsapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "user")
    private Set<Image> images;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public static final class UserBuilder {
        private Long id;
        private Set<Image> images;

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withImages(Set<Image> images) {
            this.images = images;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.images = this.images;
            return user;
        }
    }
}
