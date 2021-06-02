package com.AlbertAbuav.AuthorVsBooks.wrappers;

import com.AlbertAbuav.AuthorVsBooks.beans.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListOfBooks {
    private List<Book> books = new ArrayList<>();


}
