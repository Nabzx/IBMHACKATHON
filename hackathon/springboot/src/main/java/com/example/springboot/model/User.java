package com.example.springboot.model;

import jakarta.persistence.*;



@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // This will map to the 'id' column in the 'users' table

    @Column(unique = true, nullable = false)
    private String username;  // Maps to 'username'

    @Column(unique = true, nullable = false)
    private String email;  // Maps to 'email'

    @Column(nullable = false)
    private String password;  // Maps to 'password'

    private String fullName;  // Maps to 'full_name'

    private String profilePicture;  // Maps to 'profile_picture'

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

