package com.AlbertAbuav.AuthorVsBooks.serviceimplementation;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import com.AlbertAbuav.AuthorVsBooks.repos.AuthorRepository;
import com.AlbertAbuav.AuthorVsBooks.repos.BookRepository;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImplementation implements LibraryService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.saveAndFlush(author);
    }

    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooksBetweenYears(LocalDate start, LocalDate end) throws LibraryCustomException {
        if (end.isBefore(start)) {
            throw new LibraryCustomException("The end date can't be before the start date");
        }
        return bookRepository.findByYearBetween(start, end);
    }

    @Override
    public List<Book> getAllBooksBetweenYearsByInt(int start, int end) throws LibraryCustomException {
        if (end <= start) {
            throw new LibraryCustomException("The end date can't be before the start date");
        }
        return bookRepository.findBySinghYearBetween(start, end);
    }

}
