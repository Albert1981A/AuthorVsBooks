package com.AlbertAbuav.AuthorVsBooks.beans;

import com.AlbertAbuav.AuthorVsBooks.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "print_year", nullable = false)
    private LocalDate year;

    @Column(name = "the_year", nullable = false)
    private int singhYear;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + DateUtils.formattedDate(year) +
                ", singhYear=" + singhYear +
                '}';
    }
}
