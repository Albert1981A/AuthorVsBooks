package com.AlbertAbuav.AuthorVsBooks.task;

import com.AlbertAbuav.AuthorVsBooks.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RemoveExpiredToken {

    private final TokenManager tokenManager;

    @Scheduled(fixedRate = 1000*60*10)
    public void deleteEvery10Minutes() {
        tokenManager.removeExpiredToken(10);
    }
}
