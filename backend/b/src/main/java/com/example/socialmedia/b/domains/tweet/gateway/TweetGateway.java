package com.example.socialmedia.b.domains.tweet.gateway;

import java.util.List;

import com.example.socialmedia.b.domains.tweet.entities.Tweet;

public interface TweetGateway {
    
    public void create(String tweet);

    public void update(String tweet);

    public Tweet findById(String id);

    public List<Tweet> findByAuthorId(String authorId);

}