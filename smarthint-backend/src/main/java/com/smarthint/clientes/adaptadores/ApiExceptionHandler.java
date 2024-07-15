package com.smarthint.clientes.adaptadores;

import com.mongodb.MongoWriteException;
import com.smarthint.clientes.aplicacao.core.exceptions.ClienteInvalidoException;
import com.smarthint.clientes.aplicacao.core.exceptions.out.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Objects;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleThrowable(MethodArgumentNotValidException ex, Locale locale) {
        ErrorResponse errorResponse = new ErrorResponse(
                String.format(" %s inválido, %s ", Objects.requireNonNull(ex.getFieldError()).getField(), ex.getFieldError().getDefaultMessage())
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<ErrorResponse> handleThrowable(MongoWriteException ex, Locale locale) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleThrowable(ClienteInvalidoException ex, Locale locale) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleThrowable(ClienteNaoEncontradoException ex, Locale locale) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
