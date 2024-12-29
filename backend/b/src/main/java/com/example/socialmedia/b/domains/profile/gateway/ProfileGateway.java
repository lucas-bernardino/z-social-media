package com.example.socialmedia.b.domains.profile.gateway;

import java.util.List;

import com.example.socialmedia.b.domains.profile.entities.Profile;

public interface ProfileGateway {
    
    public void create(final Profile profile);

    public void update(final Profile profile);

    public Profile findById(final String id);

    public Profile findByLogin(final String login);

    public List<Profile> searchByLogin(final String login);

    public List<Profile> findFollowedByProfileId(final String id);
}
