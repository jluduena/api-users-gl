package com.gl.exercice.apiusers.dao;

import com.gl.exercice.apiusers.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPhoneDao extends JpaRepository<Phone, UUID> {
}
