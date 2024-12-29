package com.example.socialmedia.b.services.tweet.implementation;

import java.util.List;

import com.example.socialmedia.b.domains.profile.gateway.ProfileGateway;
import com.example.socialmedia.b.domains.tweet.entities.Tweet;
import com.example.socialmedia.b.domains.tweet.gateway.TweetGateway;
import com.example.socialmedia.b.services.tweet.TweetService;

public class TweetServiceImplementation implements TweetService {

    private TweetGateway tweetGateway;
    private ProfileGateway profileGateway;

    private TweetServiceImplementation(TweetGateway tweetGateway, ProfileGateway profileGateway) {
        this.tweetGateway = tweetGateway;
        this.profileGateway = profileGateway;
    }

    public static TweetServiceImplementation build(final TweetGateway tweetGateway, final ProfileGateway profileGateway) {
        return new TweetServiceImplementation(tweetGateway, profileGateway);
    }

    @Override
    public Tweet create(String authorLogin, String content) {
        final var author = this.profileGateway.findByLogin(authorLogin);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        final var tweet = Tweet.build(content, author.getId(), author.getLogin());

        this.tweetGateway.create(tweet);

        return tweet;
    }

    @Override
    public Tweet like(String id) {
        final var tweet = this.tweetGateway.findById(id);

        if (tweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        tweet.like();

        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public Tweet unlike(String id) {
        final var tweet = this.tweetGateway.findById(id);

        if (tweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        tweet.dislike();

        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public Tweet view(String id) {
        final var tweet = this.tweetGateway.findById(id);

        if (tweet == null) {
            throw new IllegalArgumentException("Tweet not found");
        }

        tweet.view();

        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public List<Tweet> findByAuthor(String authorLogin) {
        final var author = this.profileGateway.findByLogin(authorLogin);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        return this.tweetGateway.findByAuthorId(author.getId());
    }

    @Override
    public List<Tweet> findByFollowed(String profileLogin) {
        final var profile = this.profileGateway.findByLogin(profileLogin);

        if (profile == null) {
            throw new IllegalArgumentException("Profile not found");
        }

        final var followed = this.profileGateway.findFollowedByProfileId(profileLogin);

        final var tweets = followed.stream()
            .map(f -> this.tweetGateway.findByAuthorId(f.getId()))
            .flatMap(List::stream)
            .toList();

        final var orderedTweets = tweets.stream()
            .sorted((t1, t2) -> t1.getCreatedAt().compareTo(t2.getCreatedAt()))
            .toList();

        return orderedTweets;
    }
}
