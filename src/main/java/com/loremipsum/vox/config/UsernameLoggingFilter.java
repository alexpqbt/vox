package com.loremipsum.vox.config;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsernameLoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
      // TODO Auto-generated method stub
    
        if ("/login".equals(request.getRequestURI()) && "POST".equals(request.getMethod())) {
            System.out.println("Submitted username param = [" + request.getParameter("username") + "]");
        }

        filterChain.doFilter(request, response);
    } 
}
