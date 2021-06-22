package com.gl.exercice.apiusers.exeptions;

public class PasswordFormatExeption extends ConflictExeption{
    public PasswordFormatExeption() {
        super("The password does not comply with the correct format");
    }
}
