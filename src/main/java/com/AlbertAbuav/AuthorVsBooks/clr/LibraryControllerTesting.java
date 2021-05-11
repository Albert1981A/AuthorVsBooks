package com.AlbertAbuav.AuthorVsBooks.clr;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import com.AlbertAbuav.AuthorVsBooks.utils.ArtUtils;
import com.AlbertAbuav.AuthorVsBooks.utils.TestUtils;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfAuthors;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(3)
public class LibraryControllerTesting implements CommandLineRunner {

    private final static String BASE_URL = "http://localhost:8080/library";

    private final RestTemplate restTemplate;
    private final LibraryService libraryService;

    @Override
    public void run(String... args) {

        System.out.println(ArtUtils.LIBRARY_CONTROLLER_TESTING);

        Book b1 = Book.builder()
                .name("Java for beginners")
                .year(LocalDate.of(2019, 12, 23))
                .singhYear(2019)
                .build();

        Book b2 = Book.builder()
                .name("Html for beginners")
                .year(LocalDate.of(2017, 6, 21))
                .singhYear(2017)
                .build();

        Author a1 = Author.builder()
                .name("Reuven")
                .book(b1)
                .book(b2)
                .build();

        TestUtils.testInfo("Add Author");

        ResponseEntity<String> result1 = restTemplate.postForEntity(BASE_URL + "/authors", a1, String.class);
        System.out.println("The result of the \"post\" returns: " + result1.getStatusCodeValue());

        TestUtils.testInfo("Get all Authors");

//        ListOfAuthors result2 = restTemplate.getForObject(BASE_URL + "/authors", ListOfAuthors.class);
//        result2.getAuthors().forEach(System.out::println);

        TestUtils.testInfo("Get all Books");

        ListOfBooks result3 = restTemplate.getForObject(BASE_URL + "/books", ListOfBooks.class);
        result3.getBooks().forEach(System.out::println);

        TestUtils.testInfo("Update Author");

        Author authorToUpdate = libraryService.getAllAuthors().get(0);
        System.out.println("This is the Author to update: " + authorToUpdate);
        authorToUpdate.setName("Updated Name");
        restTemplate.put(BASE_URL + "/authors", authorToUpdate, String.class);
        System.out.println("The Author after the update: " + libraryService.getAllAuthors().get(0));

        TestUtils.testInfo("Delete Author by ID");

        restTemplate.delete(BASE_URL + "/authors/" + authorToUpdate.getId(),authorToUpdate, String.class);
        System.out.println("Attempt to get the Author id-" + authorToUpdate.getId() + " after deleting him: \n" + libraryService.getAllAuthors().get(0));

        TestUtils.testInfo("Get all Books between years");

        ListOfBooks result4 = restTemplate.getForObject(BASE_URL + "/books/date/between?start=1994-02-21&end=2021-02-21", ListOfBooks.class);
        result4.getBooks().forEach(System.out::println);

        TestUtils.testInfo("Get all Books between years by int");

        ListOfBooks result5 = restTemplate.getForObject(BASE_URL + "/books/date/between/by-int?start=1994&end=2018", ListOfBooks.class);
        result5.getBooks().forEach(System.out::println);


    }
}
