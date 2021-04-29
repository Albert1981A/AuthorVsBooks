package com.AlbertAbuav.AuthorVsBooks.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AUTHOR_VS_BOOKS", joinColumns = @JoinColumn(name = "THE_AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "THE_BOOK_ID")
    )  // ==> Will define the names of the new Table: the Table named "author_vs_books" with to columns: "the_author_id" and "the_book_id"
    @Singular // ==> Works with Builder and initializes the list and let us insert a single book each time
    private List<Book> books = new ArrayList<>();

}
