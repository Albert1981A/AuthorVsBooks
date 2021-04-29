package com.AlbertAbuav.AuthorVsBooks.repos;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
