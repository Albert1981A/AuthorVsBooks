package com.AlbertAbuav.AuthorVsBooks.controllers;

import com.AlbertAbuav.AuthorVsBooks.security.TokenManager;
import com.AlbertAbuav.AuthorVsBooks.service.LibraryService;
import com.AlbertAbuav.AuthorVsBooks.serviceimplementation.ClientService;
import com.AlbertAbuav.AuthorVsBooks.serviceimplementation.LibraryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private LibraryServiceImplementation libraryServiceImplementation;

    @PostMapping
    public ResponseEntity<?> register(@RequestParam String name) {
        return new ResponseEntity<>(tokenManager.register(libraryServiceImplementation), HttpStatus.CREATED);
    }
}
