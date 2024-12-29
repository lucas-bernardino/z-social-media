package com.example.socialmedia.b.services.profile.implementation;

import java.util.List;

import com.example.socialmedia.b.domains.profile.entities.Profile;
import com.example.socialmedia.b.domains.profile.gateway.ProfileGateway;
import com.example.socialmedia.b.services.profile.ProfileService;

public class ProfileServiceImplementation implements ProfileService {

    private ProfileGateway profileGateway;

    private ProfileServiceImplementation(ProfileGateway profileGateway) {
        this.profileGateway = profileGateway;
    }

    public static ProfileServiceImplementation build(ProfileGateway profileGateway) {
        return new ProfileServiceImplementation(profileGateway);
    }

    @Override
    public Profile get(String login) {
        final var aProfile = this.profileGateway.findByLogin(login);

        return aProfile;
    }

    @Override
    public Profile follow(String followerLogin, String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);

        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if (aFollowerProfile == null) {
            throw new IllegalArgumentException("Follower profile not found");
        }

        if (aFollowedProfile == null) {
            throw new IllegalArgumentException("Followed profile not found");
        }

        aFollowerProfile.follow(aFollowedProfile);

        this.profileGateway.update(aFollowerProfile);

        return aFollowerProfile;
    }

    @Override
    public Profile create(String aName, String aLogin, String anEmail) {
        final var existentProfile = this.profileGateway.findByLogin(aLogin);
        
        if (existentProfile != null) {
            throw new IllegalArgumentException("Profile already exists");
        }

        final var aProfile = Profile.build(aName, anEmail, aLogin);

        this.profileGateway.create(aProfile);

        return aProfile;

    }

    @Override
    public List<Profile> search(String login) {
        
        final var aProfiles = this.profileGateway.searchByLogin(login);

        return aProfiles;
    }

    @Override
    public boolean isFollowing(String followerLogin, String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);

        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if (aFollowerProfile == null) {
            throw new IllegalArgumentException("Follower profile not found");
        }

        if (aFollowedProfile == null) {
            throw new IllegalArgumentException("Followed profile not found");
        }

        return aFollowerProfile.getFollowed().containsKey(aFollowedProfile.getId());
    }
    
}
