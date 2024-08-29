package org.example.intern.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class CustomResourceNotFoundException extends RuntimeException {
        public CustomResourceNotFoundException(String message) {
            super(message);
        }
    }

    public static class CustomResourceNotFoundExceptionV2 extends RuntimeException {
        public CustomResourceNotFoundExceptionV2(String message) {
            super(message);
        }
    }


}
