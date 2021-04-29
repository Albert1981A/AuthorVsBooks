package com.AlbertAbuav.AuthorVsBooks.exceptions;

public class LibraryCustomException extends Exception{

    public LibraryCustomException(String message) {
        super("This is a library custom exception: "+message);
    }
}
