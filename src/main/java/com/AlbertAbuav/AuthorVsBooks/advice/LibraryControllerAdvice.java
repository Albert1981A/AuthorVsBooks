package com.AlbertAbuav.AuthorVsBooks.advice;

import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class LibraryControllerAdvice {

    @ExceptionHandler(value = {LibraryCustomException.class})
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("LOL", e.getMessage());
    }

}
