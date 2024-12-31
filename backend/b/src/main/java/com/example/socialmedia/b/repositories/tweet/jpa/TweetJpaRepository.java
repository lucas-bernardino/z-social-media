package com.example.socialmedia.b.repositories.tweet.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmedia.b.repositories.tweet.jpa.model.TweetJpaModel;

public interface TweetJpaRepository extends JpaRepository<TweetJpaModel, String> {
    
}
