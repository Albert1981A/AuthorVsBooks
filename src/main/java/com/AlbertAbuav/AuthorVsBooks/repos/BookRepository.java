package com.AlbertAbuav.AuthorVsBooks.repos;


import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByYearBetween(LocalDate start, LocalDate end);
    List<Book> findBySinghYearBetween(int start, int end);
}
