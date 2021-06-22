package com.gl.exercice.apiusers.utils;

public enum RegexType {

    EMAIL("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"),
    PASSWORD("^([A-Z])([a-z]*)[0-9]{2}$");

    private String pattern;

    RegexType(String pattern){
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
