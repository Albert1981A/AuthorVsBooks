package com.AlbertAbuav.AuthorVsBooks.config;

import com.AlbertAbuav.AuthorVsBooks.security.Information;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecConfig {

    @Bean
    public Map<String, Information> map() {
        return new HashMap<>();
    }
}
