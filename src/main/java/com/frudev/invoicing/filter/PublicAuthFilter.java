package com.frudev.invoicing.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frudev.invoicing.dto.ResponseDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class PublicAuthFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    public PublicAuthFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // Implement public API specific authentication/validation if required
        // For now, it just passes the request through
        
        filterChain.doFilter(request, response);
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseDto<Void> responseDto = new ResponseDto<>(null, message);
        response.getWriter().write(objectMapper.writeValueAsString(responseDto));
    }
}
