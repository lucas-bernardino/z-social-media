package com.example.socialmedia.b.repositories.tweet.jpa.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.socialmedia.b.repositories.profile.jpa.model.ProfileJpaModel;

@Entity(name="Tweet")
@Table(name="tweets")
public class TweetJpaModel {
    
    @Id
    @Column(name="id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name="content", nullable = false)
    private String content;



    @ManyToOne(targetEntity = ProfileJpaModel.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false),
                  @JoinColumn(name = "author_login", referencedColumnName = "login", nullable = false)})
    private ProfileJpaModel author;
    
    
    @Column(name = "likes", nullable = false)
    private int likes;

    @Column(name = "views", nullable = false)
    private int views;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public TweetJpaModel() {
    }

    public TweetJpaModel(String id, String content, ProfileJpaModel author, int likes, int views, Instant createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.views = views;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProfileJpaModel getAuthor() {
        return author;
    }

    public void setAuthor(ProfileJpaModel author) {
        this.author = author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    

}
