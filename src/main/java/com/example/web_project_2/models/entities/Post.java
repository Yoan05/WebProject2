package com.example.web_project_2.models.entities;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{
    @Column(name = "picture", nullable = false)
    private String pictureURL;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity postedBy;
    @ManyToMany
    private Set<UserEntity> likedBy;

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(UserEntity postedBy) {
        this.postedBy = postedBy;
    }

    public Set<UserEntity> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(Set<UserEntity> likedBy) {
        this.likedBy = likedBy;
    }
}
