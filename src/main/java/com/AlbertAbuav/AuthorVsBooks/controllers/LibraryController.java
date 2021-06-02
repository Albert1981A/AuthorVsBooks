package com.AlbertAbuav.AuthorVsBooks.controllers;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibrarySecurityException;
import com.AlbertAbuav.AuthorVsBooks.security.TokenManager;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfAuthors;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.DocFlavor;
import java.time.LocalDate;

@RestController
@RequestMapping("library")  //==>  http://localhost:8080/library
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;
    private final TokenManager tokenManager;

    @PostMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        libraryService.addAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED); // Return 201 (created)
    }

    @GetMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> getAllAuthors(@RequestHeader(name = "Authorization") String token) throws LibrarySecurityException {
        if (!tokenManager.isExist(token)) {
            throw new LibrarySecurityException("You are not allowed to enter");
        }
        return new ResponseEntity<>(new ListOfAuthors(libraryService.getAllAuthors()), HttpStatus.OK); //==> Return body + 200
    }

    @GetMapping("books")  //==>  http://localhost:8080/library/books
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(new ListOfBooks(libraryService.getAllBooks()), HttpStatus.OK); //==> Return body + 200
    }

    @DeleteMapping("authors/{id}")  //==>  http://localhost:8080/library/authors/4
    public ResponseEntity<?> deleteAuthorById(@PathVariable int id) {
        libraryService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //==> Return 204 (ok and no content)
    }

    @GetMapping("books/date/between")  //==>  http://localhost:8080/library/books/date/between
    public ResponseEntity<?> getAllBooksBetweenYears(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                     @RequestParam("end")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) throws LibraryCustomException {
        return new ResponseEntity<>(new ListOfBooks(libraryService.getAllBooksBetweenYears(start, end)), HttpStatus.OK);
    }

    @GetMapping("books/date/between/by-int")  //==>  http://localhost:8080/library/books/date/between/by-int
    public ResponseEntity<?> getAllBooksBetweenYearsByInt(@RequestParam int start, @RequestParam int end) throws LibraryCustomException {
        return new ResponseEntity<>(new ListOfBooks(libraryService.getAllBooksBetweenYearsByInt(start, end)), HttpStatus.OK);
    }

    @PutMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        libraryService.updateAuthor(author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //==> Return 204 (ok and no content)
    }

}
