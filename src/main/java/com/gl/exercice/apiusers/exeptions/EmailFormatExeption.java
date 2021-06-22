package com.gl.exercice.apiusers.exeptions;

public class EmailFormatExeption extends ApplicationException{
    public EmailFormatExeption() {
        super("The email does not comply with the correct format");
    }
}
