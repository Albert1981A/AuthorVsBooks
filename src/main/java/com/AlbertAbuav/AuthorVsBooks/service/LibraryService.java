package com.AlbertAbuav.AuthorVsBooks.service;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;

import java.time.LocalDate;
import java.util.List;

public interface LibraryService {

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthorById(int id);

    List<Book> getAllBooks();

    List<Author> getAllAuthors();

    List<com.AlbertAbuav.AuthorVsBooks.beans.Book> getAllBooksBetweenYears(LocalDate start, LocalDate end) throws LibraryCustomException;

    List<com.AlbertAbuav.AuthorVsBooks.beans.Book> getAllBooksBetweenYearsByInt(int start, int end) throws LibraryCustomException;

}
