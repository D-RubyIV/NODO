package org.example.intern.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CustomErrors {
        @JsonProperty(value = "statusCode")
        HttpStatus httpStatus;
        @JsonProperty(value = "errors")
        private Map<String, String> errors;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class CustomError {
        @JsonProperty(value = "statusCode")
        HttpStatus httpStatus;
        @JsonProperty(value = "error")
        private String error;
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Giá trị nhập vào không hợp lệ. Vui lòng nhập đúng định dạng.";
        return message;
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> handleBindException(BindException ex) {
        Map<String, String> mapErrors = new HashMap<>();
        List<FieldError> listError = ex.getFieldErrors();
        listError.forEach(s -> {
            String code = s.getCode();
            System.out.println("CODE: " + s.getCode());
            System.out.println(s.getDefaultMessage());
            if (code != null) {
                if (code.equals("typeMismatch")) {
                    String message = messageSource.getMessage(code, new Object[]{}, LocaleContextHolder.getLocale());
                    mapErrors.put(s.getField(), message);

                } else {
                    String message = messageSource.getMessage(s.getDefaultMessage(), new Object[]{}, LocaleContextHolder.getLocale());
                    mapErrors.put(s.getField(), message);
                }
            }


        });
        CustomErrors error = new CustomErrors(HttpStatus.BAD_REQUEST, mapErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestsException(BadRequestException ex) {
        CustomError error = new CustomError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        String fieldName = extractDuplicateFieldName(ex.getMessage());
        String message = messageSource.getMessage("SQLIntegrityConstraintViolationException", new Object[]{fieldName}, LocaleContextHolder.getLocale());
        CustomError error = new CustomError(HttpStatus.BAD_REQUEST, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<CustomErrors> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getFieldErrors().forEach(s -> {
//            String key = s.getField();
//            String code = s.getCode();
//            if (code != null){
//                errors.put(key, messageSource.getMessage(code, new Object[]{}, LocaleContextHolder.getLocale()));
//            }
//
//        });
//        CustomErrors customErrors = new CustomErrors();
//        customErrors.setErrors(errors);
//        customErrors.setHttpStatus(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.badRequest().body(customErrors);
//    }

    private String extractDuplicateFieldName(String errorMessage) {
        String fieldName = "";
        String[] parts = errorMessage.split("for key ")[1].split("\\.");
        if (parts.length > 1) {
            fieldName = parts[1].replace("'", "").trim();
        }
        return fieldName;
    }

    private Object[] extractValueBetween(String errorMessage) {
        System.out.println(errorMessage);
        String start = errorMessage.split("between")[1].split("and")[0].trim();
        String end = errorMessage.split("and")[1].trim();
        return new Object[]{start, end};
    }
}