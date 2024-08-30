package com.example.exception;

import java.io.Serial;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@Component
@RestControllerAdvice
public class Errors implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
    private Map<String, Object> createErrorResponse(String message, HttpStatus status) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("Erro", message);
        errors.put("Codigo", status.value());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        errors.put("Codigo", HttpStatus.BAD_REQUEST.value());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleValidationExceptions(ConstraintViolationException ex) {
        return createErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public Map<String, Object> handleIllegalStateException(IllegalStateException ex) {
        return createErrorResponse("O endpoint falhou: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, Object> handleNoSuchElementException(NoSuchElementException ex) {
        return createErrorResponse(ex.getMessage() + " Não foi encontrado", HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(NumberFormatException.class)
    public Map<String, Object> handleNumberFormatException(NumberFormatException ex) {
        return createErrorResponse("O formato de dado " + ex.getMessage() + " é inválido!", HttpStatus.NOT_ACCEPTABLE);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleInternalException(Exception ex) {
        return createErrorResponse("O endpoint falhou: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return createErrorResponse("Falha de integridade de dados: " + ex.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public Map<String, Object> handleSQLException(SQLException ex) {
        return createErrorResponse("Falha SQL: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}
