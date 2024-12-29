package com.example.socialmedia.b.domains.profile.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {

    private String id;
    private String name;
    private String email;
    private String login;
    private Map<String, Profile> followed;

    private Profile(final String id, final String name, final String email, final String login, final Map<String, Profile> followed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.followed = followed;
        this.validate();
    }

    // Used to create a brand new profile
    public static Profile build(final String aName, final String anEmail, final String aLogin) {
        return new Profile(UUID.randomUUID().toString(), aName, anEmail, aLogin, new HashMap<String, Profile>());
    }

    // Used to create a profile from the database
    public static Profile with (final String anId, final String aName, final String anEmail, final String aLogin, 
    final Map<String, Profile> aFollowed) {
        return new Profile(anId, aName, anEmail, aLogin, aFollowed);
    }

    private void validate() {
        if (this.id == null || this.id.isEmpty()) {
            throw new IllegalArgumentException("Id is required");
        }
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (this.email == null || this.email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (this.login == null || this.login.isEmpty()) {
            throw new IllegalArgumentException("Login is required");
        }
        if (this.followed == null) {
            throw new IllegalArgumentException("Followed is required");
        }
    }

    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLogin() {
        return this.login;
    }

    public Map<String, Profile> getFollowed() {
        return this.followed;
    }

    public void follow(Profile profile) {
        this.followed.put(profile.getId(), profile);
    }

    public void unfollow(Profile profile) {
        this.followed.remove(profile.getId());
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
        Profile other = (Profile) obj;
        return this.id.equals(other.id);
    }
}
