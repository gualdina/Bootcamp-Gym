package com.gym.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({NameNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(NameNotFoundException exception) {
        return new HttpErrorResponse(
                404,
                "Customer Not Found",
                LocalDateTime.now()
        );
    }
    @ExceptionHandler({GymSpaceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(NameNotFoundException exception) {
        return new HttpErrorResponse(
                404,
                "Gym Not Found",
                LocalDateTime.now()
        );
    }
}
