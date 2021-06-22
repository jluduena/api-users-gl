package com.gl.exercice.apiusers.services.impl;

import com.gl.exercice.apiusers.dao.IPhoneDao;
import com.gl.exercice.apiusers.dao.IUserDao;
import com.gl.exercice.apiusers.dtos.PhoneDTO;
import com.gl.exercice.apiusers.dtos.UserDTO;
import com.gl.exercice.apiusers.exeptions.ApplicationException;
import com.gl.exercice.apiusers.exeptions.ConflictExeption;
import com.gl.exercice.apiusers.exeptions.EmailFormatExeption;
import com.gl.exercice.apiusers.exeptions.PasswordFormatExeption;
import com.gl.exercice.apiusers.models.Phone;
import com.gl.exercice.apiusers.models.User;
import com.gl.exercice.apiusers.responses.UserResponse;
import com.gl.exercice.apiusers.services.IJWTService;
import com.gl.exercice.apiusers.services.IUserService;
import com.gl.exercice.apiusers.utils.RegexType;
import com.gl.exercice.apiusers.utils.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    final RegexUtil regexUtil;
    final IUserDao userDao;
    final IPhoneDao phoneDao;
    final IJWTService jwtService;

    public UserServiceImpl(RegexUtil regexUtil, IUserDao userDao, IPhoneDao phoneDao, IJWTService jwtService) {
        this.regexUtil = regexUtil;
        this.userDao = userDao;
        this.phoneDao = phoneDao;
        this.jwtService = jwtService;
    }

    @Override
    @Transactional
    public UserResponse saveUser(UserDTO userDTO) throws ConflictExeption {
        // validacion regex del email y la clave
        try {
            regexUtil.validate(RegexType.EMAIL,userDTO.getEmail(), EmailFormatExeption.class);
            regexUtil.validate(RegexType.PASSWORD,userDTO.getPassword(), PasswordFormatExeption.class);

        } catch (ApplicationException e){
            throw new ConflictExeption(e.getMessage());
        }

        // validacion de email existente
        Optional<User> userByEmail = userDao.findByEmail(userDTO.getEmail());
        if(userByEmail.isPresent()){
            throw new ConflictExeption("the email is already registered");
        }

        // genero el usuario nuevo a partir del DTO
        User newUser = getUserByDTO(userDTO);
        newUser = userDao.save(newUser);
        UserResponse userResponse = new UserResponse(newUser);

        return userResponse;

    }

    private User getUserByDTO(UserDTO userDTO) {
        User newUser = new User(userDTO);

        // genero el token y se lo seteo al usuario
        newUser.setToken(jwtService.generateJWTToken(userDTO.getEmail()));

        // registro los teléfonos del usuario
        List<Phone> phones = new ArrayList<>();
        for(PhoneDTO phoneDTO: userDTO.getPhones()){
            phones.add(phoneDao.save(new Phone(phoneDTO)));
        }

        newUser.setPhones(phones);

        return newUser;
    }

}
