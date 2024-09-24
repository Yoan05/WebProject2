package com.example.web_project_2.models.entities;

import javax.persistence.*;

import jdk.jfr.ContentType;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;
import java.util.Set;

//posts @OneToMany
//tweets @OneToMany
//too early//List<UserEntity>friends @ManyToMany

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String bio;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roles;

    @OneToMany(mappedBy = "postedBy")
    private Set<Post> posts;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
