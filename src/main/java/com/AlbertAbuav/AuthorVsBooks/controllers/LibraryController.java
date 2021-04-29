package com.AlbertAbuav.AuthorVsBooks.controllers;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("library")  //==>  http://localhost:8080/library
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        libraryService.addAuthor(author);
        return new ResponseEntity<>(HttpStatus.CREATED); // Return 201 (created)
    }

    @GetMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> getAllAuthors() {
        return new ResponseEntity<>(libraryService.getAllAuthors(), HttpStatus.OK); //==> Return body + 200
    }

    @GetMapping("books")  //==>  http://localhost:8080/library/books
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(libraryService.getAllBooks(), HttpStatus.OK); //==> Return body + 200
    }

    @DeleteMapping("authors/{id}")  //==>  http://localhost:8080/library/authors/4
    public ResponseEntity<?> deleteAuthorById(@PathVariable int id) {
        libraryService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //==> Return 204 204 (ok and no content)
    }

//    @GetMapping("books/date/between")
//    public ResponseEntity<?> getAllBooksBetweenYears(@RequestParam LocalDate start, @RequestParam LocalDate end) {
//        try {
//            return new ResponseEntity<>(libraryService.getAllBooksBetweenYears(start, end), HttpStatus.OK);
//        } catch (LibraryCustomException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("books/date/between/by-int")  //==>  http://localhost:8080/library/books/date/between/by-int
    public ResponseEntity<?> getAllBooksBetweenYearsByInt(@RequestParam int start, @RequestParam int end) {
        try {
            return new ResponseEntity<>(libraryService.getAllBooksBetweenYearsByInt(start, end), HttpStatus.OK);
        } catch (LibraryCustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("authors")  //==>  http://localhost:8080/library/authors
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        libraryService.updateAuthor(author);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //==> Return 204 (ok and no content)
    }

}
