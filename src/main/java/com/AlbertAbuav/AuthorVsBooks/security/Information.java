package com.AlbertAbuav.AuthorVsBooks.security;

import com.AlbertAbuav.AuthorVsBooks.serviceimplementation.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private ClientService clientService;
    private LocalDateTime time;
}
