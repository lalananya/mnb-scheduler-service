package com.mnb.shedulerservice.config;

import com.mnb.shedulerservice.servcie.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// this will be a filter layer for all API requests, and token will be validated
public class JwtFilterForClientRequest extends OncePerRequestFilter {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // we will fetch Authorization Header, from the http request
        // we will extract token , because from request it comes as Bearer fsdgdsfd-afsgdbfdsv-asf-sdgdsg
        // we will validate the token
        // and then there is something called security context holder, this is the place which holds the security context for our application, and we will define the API filtering here

        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer")) {
            String token = authHeader.substring(7);
            if(jwtConfig.validateToken(token)) {
                String username = jwtConfig.extractUsername(token);
                UserDetails userDetails = userService.loadUserByUsername(username);

            }
        }
    }
}
