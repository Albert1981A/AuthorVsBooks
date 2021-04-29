package com.AlbertAbuav.AuthorVsBooks.clr;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.repos.AuthorRepository;
import com.AlbertAbuav.AuthorVsBooks.repos.BookRepository;
import com.AlbertAbuav.AuthorVsBooks.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Order(1)
public class InitData1 implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.INIT_DATA_1);
        System.out.println("---------------------------------------------------");

        Book b1 = Book.builder()
                .name("The Adventures of Huckleberry Finn")
                .year(LocalDate.of(2021, 2, 21))
                .singhYear(2021)
                .build();
        Book b2 = Book.builder()
                .name("The Adventures of Tom Sawyer")
                .year(LocalDate.of(2020, 3, 23))
                .singhYear(2020)
                .build();
        Book b3 = Book.builder()
                .name("Go Down, Moses")
                .year(LocalDate.of(1990, 11, 1))
                .singhYear(1990)
                .build();
        Book b4 = Book.builder()
                .name("The Wild Palms")
                .year(LocalDate.of(1995, 10, 31))
                .singhYear(1995)
                .build();

        Author a1 = Author.builder()
                .name("Mark Twain")
                .book(b1)
                .book(b2)
                .build();

        Author a2 = Author.builder()
                .name("William Faulkner")
                .book(b3)
                .book(b4)
                .build();

        //bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
        authorRepository.saveAll(Arrays.asList(a1, a2));

        authorRepository.findAll().forEach(System.out::println);

//        authorRepository.deleteById(1);
//        System.out.println("-----------------------------------------");
//
//        authorRepository.findAll().forEach(System.out::println);




    }
}
