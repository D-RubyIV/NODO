package org.example.demo22_08.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class HandleException {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Error{
        private String message;
        private Map<String, String> error;
    }

    @ExceptionHandler(BindException.class)
    public final ResponseEntity<?> handleBindException(BindException ex) {
        Map<String , String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(s -> {
            errors.put(s.getField(), s.getDefaultMessage());
        });
        Error error = new Error("Validate error", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



}