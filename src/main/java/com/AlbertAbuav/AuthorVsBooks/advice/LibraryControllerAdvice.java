package com.AlbertAbuav.AuthorVsBooks.advice;

import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibrarySecurityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class LibraryControllerAdvice {

    @ExceptionHandler(value = {LibraryCustomException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException(Exception e) {
        return new ErrorDetails("LOL", e.getMessage());
    }

    @ExceptionHandler(value = {LibrarySecurityException.class})
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ErrorDetails handleException2(Exception e) {
        return new ErrorDetails("LOL", e.getMessage());
    }

}
