package com.example.socialmedia.b.domains.tweet;

import java.time.Instant;
import java.util.UUID;

import com.example.socialmedia.b.utils.InstantUtils;

public class Tweet {

    private String id;
    private String content;
    private String authorId;
    private String authorLogin;
    private int likes;
    private int views;
    private Instant createdAt;

    public Tweet(String id, String content, String authorId, String authorLogin, int likes, int views, Instant createdAt) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.authorLogin = authorLogin;
        this.likes = likes;
        this.views = views;
        this.createdAt = createdAt;
        this.validate();
    }

    public static Tweet build(final String aContent, final String anAuthorId, final String anAuthorLogin) {
        return new Tweet(UUID.randomUUID().toString(), aContent, anAuthorId, anAuthorLogin, 0, 0, InstantUtils.now());
    }

    public static Tweet with(final String anId, final String aContent, final String anAuthorId, final String anAuthorLogin, final int aLikes, final int aViews, final Instant aCreatedAt) {
        return new Tweet(anId, aContent, anAuthorId, anAuthorLogin, aLikes, aViews, aCreatedAt);
    }

    private void validate() {
        if (this.id == null || this.id.isEmpty()) {
            throw new IllegalArgumentException("Id is required");
        }
        if (this.content == null || this.content.isEmpty()) {
            throw new IllegalArgumentException("Content is required");
        }
        if (this.authorId == null || this.authorId.isEmpty()) {
            throw new IllegalArgumentException("AuthorId is required");
        }
        if (this.authorLogin == null || this.authorLogin.isEmpty()) {
            throw new IllegalArgumentException("AuthorLogin is required");
        }
        if (this.likes < 0) {
            throw new IllegalArgumentException("Likes cannot be negative");
        }
        if (this.views < 0) {
            throw new IllegalArgumentException("Views cannot be negative");
        }
        if (this.createdAt == null) {
            throw new IllegalArgumentException("CreatedAt is required");
        }
    }
    
    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void like() {
        this.likes++;
    }

    public void dislike() {
        this.likes--;
    }

    public void view() {
        this.views++;
    }

    public Instant getPastTimeSinceCreation() {
        return InstantUtils.now().minusSeconds(this.createdAt.getEpochSecond());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Tweet other = (Tweet) obj;
        return this.id.equals(other.id);
    }

}
