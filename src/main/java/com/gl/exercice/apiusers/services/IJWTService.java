package com.gl.exercice.apiusers.services;

import org.springframework.stereotype.Service;

public interface IJWTService {

    String generateJWTToken(String password);

}
