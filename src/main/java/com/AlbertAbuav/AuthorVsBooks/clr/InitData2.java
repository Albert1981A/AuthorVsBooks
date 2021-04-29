package com.AlbertAbuav.AuthorVsBooks.clr;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.exceptions.LibraryCustomException;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import com.AlbertAbuav.AuthorVsBooks.utils.ArtUtils;
import com.AlbertAbuav.AuthorVsBooks.utils.TestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(2)
public class InitData2 implements CommandLineRunner {

    private final LibraryService libraryService;

    @Override
    public void run(String... args) {

        System.out.println(ArtUtils.INIT_DATA_2);
        System.out.println("----------------------------------------");

        TestUtils.testInfo("Add Author");

        Book b5 = Book.builder()
                .name("Pet Sematary")
                .year(LocalDate.of(1983, 8, 23))
                .singhYear(1983)
                .build();
        Book b6 = Book.builder()
                .name("The Shining")
                .year(LocalDate.of(1977, 2, 25))
                .singhYear(1977)
                .build();
        Author a3 = Author.builder()
                .name("Stephen King")
                .book(b5)
                .book(b6)
                .build();

        libraryService.addAuthor(a3);
        libraryService.getAllBooks().forEach(System.out::println);;

        TestUtils.testInfo("Delete Author by id");
        libraryService.deleteAuthorById(3);
        libraryService.getAllBooks().forEach(System.out::println);;

        TestUtils.testInfo("Get all books");
        libraryService.getAllBooks().forEach(System.out::println);;

        TestUtils.testInfo("Get all books between years");
        try {
            libraryService.getAllBooksBetweenYears(LocalDate.of(1994, 2, 23), LocalDate.of(2020, 4, 21)).forEach(System.out::println);
            System.out.println("------------------------------------------------------------------------------");
            libraryService.getAllBooksBetweenYears(LocalDate.of(2020, 4, 21), LocalDate.of(1994, 2, 23)).forEach(System.out::println);
        } catch (LibraryCustomException e) {
            System.out.println(e.getMessage());
        }

        TestUtils.testInfo("Get all books between years By int");

        try {
            libraryService.getAllBooksBetweenYearsByInt(1994, 2022).forEach(System.out::println);
            System.out.println("------------------------------------------------------------------------------");
            libraryService.getAllBooksBetweenYearsByInt(2022, 1994).forEach(System.out::println);
        } catch (LibraryCustomException e) {
            System.out.println(e.getMessage());
        }

    }
}
