package com.AlbertAbuav.AuthorVsBooks.security;

import com.AlbertAbuav.AuthorVsBooks.serviceimplementation.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenManager {

    @Autowired
    private Map<String, Information> map;

    public String register(ClientService clientService) {
        String token = UUID.randomUUID().toString();
        map.put(token, new Information(clientService, LocalDateTime.now()));
        return token;
    }

    public boolean isExist(String token) {
        if (map.containsKey(token)) {
            return true;
        }
        return false;
    }

}
