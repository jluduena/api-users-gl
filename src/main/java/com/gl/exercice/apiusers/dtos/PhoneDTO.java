package com.gl.exercice.apiusers.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PhoneDTO implements Serializable {

    @NotNull( message = "phone.number is required")
    private String number;

    @NotNull( message = "phone.citycode is required")
    @JsonAlias("citycode")
    private String cityCode;

    @NotNull( message = "phone.contrycode is required")
    @JsonAlias("contrycode")
    private String countryCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
