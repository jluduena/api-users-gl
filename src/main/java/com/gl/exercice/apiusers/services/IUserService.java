package com.gl.exercice.apiusers.services;

import com.gl.exercice.apiusers.dtos.UserDTO;
import com.gl.exercice.apiusers.exeptions.ApplicationException;
import com.gl.exercice.apiusers.exeptions.ConflictExeption;
import com.gl.exercice.apiusers.responses.UserResponse;

public interface IUserService {
    UserResponse saveUser(UserDTO userDTO) throws ApplicationException, ConflictExeption;
}
