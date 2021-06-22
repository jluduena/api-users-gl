package com.gl.exercice.apiusers.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

    @NotNull( message = "user.name is required")
    private String name;

    @NotNull( message = "user.email is required")
    private String email;

    @NotNull( message = "user.password is required")
    private String password;

    @NotNull( message = "user.phones is required")
    private List<@Valid PhoneDTO> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }
}
