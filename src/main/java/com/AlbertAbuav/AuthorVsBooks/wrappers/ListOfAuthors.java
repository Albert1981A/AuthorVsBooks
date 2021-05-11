package com.AlbertAbuav.AuthorVsBooks.wrappers;

import com.AlbertAbuav.AuthorVsBooks.beans.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfAuthors {
    private List<Author> authors = new ArrayList<>();
}
