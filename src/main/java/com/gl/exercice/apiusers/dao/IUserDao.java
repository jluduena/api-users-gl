package com.gl.exercice.apiusers.dao;

import com.gl.exercice.apiusers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserDao extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
