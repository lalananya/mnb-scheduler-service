package com.mnb.shedulerservice.config;

import com.mnb.shedulerservice.servcie.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
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
                // this is Spring Security object that represents an authenticated user
                // 1st arg - authenticated userdetail reference
                // 2nd arg - null , at this stage password is not needed, as the user is already authenticated
                // 3rd arg - getAuthorities, the validated usee is authorized for which roles exactly
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // attach extra information about the authentication request like remote IP and sessionID
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Security context holds the current logged-in user info,
                // by setting authentication , now spring security is aware of which user is requesting and what is role permissions they have

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // after this Filter handking, we can access security context, user, authentication , role / name anything


                // every request before moving forward with controller code, doFilterInternal(), will be executed, and validated
                // once you are done validating, you need to give control back to controller for further steps
                // below code ensures that, else we will get stuck in this filter function only
                filterChain.doFilter(request, response);
            }
        }
    }
}
