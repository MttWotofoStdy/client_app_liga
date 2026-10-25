package com.matveyperestoronin.client_app_liga_cifrovoy_economici.exception;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(EntityNotFoundException ex) {
        Map<String, String> exceptionOut = new HashMap<>();
        exceptionOut.put("error", "Сущность отсутствует");
        exceptionOut.put("message", ex.getMessage());

        return ResponseEntity.status(404).body(exceptionOut);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> exceptionOut = new HashMap<>();
        exceptionOut.put("error", "Неверное значение");
        exceptionOut.put("message", ex.getMessage());
        return ResponseEntity.status(400).body(exceptionOut);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleMethodValid(HandlerMethodValidationException ex) {
        Map<String, String> exceptionOut = new HashMap<>();
        exceptionOut.put("error", "Неверное значение");
        exceptionOut.put("message", ex.getMessage());
        return ResponseEntity.status(400).body(exceptionOut);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Map<String, String>> constraintViolotaion(ConstraintViolationException ex) {
//        Map<String, String> exceptionOut = new HashMap<>();
//        exceptionOut.put("error", "Не в рамках ограничений");
//        exceptionOut.put("message", ex.getMessage());
//        return ResponseEntity.status(400).body(exceptionOut);
//    }
}
