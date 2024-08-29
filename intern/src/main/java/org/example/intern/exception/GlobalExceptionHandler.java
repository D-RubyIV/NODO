package org.example.intern.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CustomErrors {
        @JsonProperty(value = "errors")
        private Map<String, String> errors;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CustomError {
        @JsonProperty(value = "error")
        private String error;
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestsException(BadRequestException ex) {
        CustomError error = new CustomError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        CustomError error = new CustomError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(s -> {
            String key = s.getField();
            String code = s.getCode();
            errors.put(key, messageSource.getMessage(code, new Object[]{key}, LocaleContextHolder.getLocale()));
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}