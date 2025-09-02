package com.mnb.shedulerservice.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;

import java.security.Key;
import java.util.Date;

@Configuration
public class JwtConfig {

    // generate the secret key using Keys provided by JWt package only
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // this key will newly generated evertime the application restart, you can
    // instead use a static key
    private final Long expiration = (1000l * 60l * 60l); // valid for 1 hour

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();

        /**
         * JWT take the subject - against which we are genrating token
         * - setSubject, expiration, IssueAt date,
         * - the secret is used to combine this generate unecrypted token into secret one
         * - thus we sign In with key,
         * - compact() forms final one
         */
    }

    // this is used by every other API, so that we can check is the token is valid
    // is also used to judge which user has request what API, and we can
    // add authorization access to those users as well

    public String validateToken(String token) {
        // we have extracted username, but for validation we also need to check
        // if it has current token or not
        String username = Jwts.parserBuilder()
                .setSigningKey(key)
                .build().parseClaimsJws(token)
                .getBody().getSubject();
        return username;
    }
}
