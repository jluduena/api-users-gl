package com.gl.exercice.apiusers.controllers;

import com.gl.exercice.apiusers.dtos.UserDTO;
import com.gl.exercice.apiusers.exeptions.ApplicationException;
import com.gl.exercice.apiusers.responses.UserResponse;
import com.gl.exercice.apiusers.services.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    private ResponseEntity<UserResponse> postUser(@Valid @RequestBody UserDTO userDTO) throws ApplicationException {

        UserResponse response = userService.saveUser(userDTO);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/test-api")
    private ResponseEntity<String> testApi() throws ApplicationException {
        return ResponseEntity.ok("OK!");

    }

}
