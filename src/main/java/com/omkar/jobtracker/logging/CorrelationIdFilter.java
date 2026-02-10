package com.omkar.jobtracker.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    public static final String CORRELATION_ID = "requestId";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 1️⃣ Generate unique ID for every request
        String requestId = UUID.randomUUID().toString();

        // 2️⃣ Put into MDC (for logging)
        MDC.put(CORRELATION_ID, requestId);

        // 3️⃣ Add into response header (very important)
        response.setHeader("X-Request-Id", requestId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            // 4️⃣ Cleanup (important to avoid memory leaks)
            MDC.clear();
        }
    }
}
