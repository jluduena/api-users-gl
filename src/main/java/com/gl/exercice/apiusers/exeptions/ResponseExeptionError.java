package com.gl.exercice.apiusers.exeptions;

public class ResponseExeptionError {
    private String message;

    public ResponseExeptionError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
