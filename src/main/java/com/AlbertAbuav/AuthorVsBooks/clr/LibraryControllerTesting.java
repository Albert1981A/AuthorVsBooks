package com.AlbertAbuav.AuthorVsBooks.clr;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import com.AlbertAbuav.AuthorVsBooks.controllers.WelcomeController;
import com.AlbertAbuav.AuthorVsBooks.security.TokenManager;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import com.AlbertAbuav.AuthorVsBooks.utils.ArtUtils;
import com.AlbertAbuav.AuthorVsBooks.utils.TestUtils;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfAuthors;
import com.AlbertAbuav.AuthorVsBooks.wrappers.ListOfBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Map;

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

        ResponseEntity<String> welcome = restTemplate.postForEntity("http://localhost:8080/welcome?name=Kobi", null, String.class);
        System.out.println("This is the Token given to Kobi: \n" + welcome.getBody());
        System.out.println();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", welcome.getBody());

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<ListOfAuthors> response = restTemplate.exchange(BASE_URL + "/authors", HttpMethod.GET, entity, ListOfAuthors.class);
        System.out.println("The status code response is: " + response.getStatusCodeValue() + "\nThis are all the Authors:");
        response.getBody().getAuthors().forEach(System.out::println);

        TestUtils.testInfo("Get all Books");

        ResponseEntity<ListOfBooks> result3 = restTemplate.getForEntity(BASE_URL + "/books", ListOfBooks.class);
        System.out.println("The status code response is: " + result3.getStatusCodeValue() + "\nThis are all the Books:");
        result3.getBody().getBooks().forEach(System.out::println);

        TestUtils.testInfo("Update Author");

        Author authorToUpdate = libraryService.getAllAuthors().get(0);
        System.out.println("This is the Author to update: \n" + authorToUpdate);
        authorToUpdate.setName("Updated Name");
        System.out.println("Attempting to update the name to - \"Updated Name\":");
        restTemplate.put(BASE_URL + "/authors", authorToUpdate);
        System.out.println("The Author after the update: \n" + libraryService.getAllAuthors().get(0));

        TestUtils.testInfo("Delete Author by ID");

        restTemplate.delete(BASE_URL + "/authors/" + authorToUpdate.getId(), authorToUpdate);
        System.out.println("Attempt to get the Author id-" + authorToUpdate.getId() + " after deleting him: \n" + libraryService.getAllAuthors().get(0));

        TestUtils.testInfo("Get all Books between years");

        ResponseEntity<ListOfBooks> result4 = restTemplate.getForEntity(BASE_URL + "/books/date/between?start=1994-02-21&end=2021-02-21", ListOfBooks.class);
        System.out.println("The status code response is: " + result4.getStatusCodeValue() + "\nThis are all the Books:");
        result4.getBody().getBooks().forEach(System.out::println);

        TestUtils.testInfo("Get all Books between years by int");

        ResponseEntity<ListOfBooks> result5 = restTemplate.getForEntity(BASE_URL + "/books/date/between/by-int?start=1994&end=2018", ListOfBooks.class);
        System.out.println("The status code response is: " + result5.getStatusCodeValue() + "\nThis are all the Books:");
        result5.getBody().getBooks().forEach(System.out::println);

    }
}
