package com.example.socialmedia.b.repositories.profile.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmedia.b.repositories.profile.jpa.model.ProfileJpaModel;

public interface ProfileJpaRepository extends JpaRepository<ProfileJpaModel, String>{

    
}
