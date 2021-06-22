package com.gl.exercice.apiusers.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExeptionManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> exeptionHandler(Exception ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                new ResponseExeptionError("Internal Server Error. - please read the application logs"),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    @ExceptionHandler(value = { ConflictExeption.class })
    protected ResponseEntity<Object> conflictExeptionHandler(ApplicationException ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                new ResponseExeptionError(ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.CONFLICT,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage() + " - ")
                .forEach(sb:: append);
        return handleExceptionInternal(
                exception,
                new ResponseExeptionError(sb.toString().substring(0, sb.toString().length()-3)),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request);

    }

}
