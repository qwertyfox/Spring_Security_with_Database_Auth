package com.qwertyfox.encrypted_password.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class JwtUsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    public JwtUsernamePasswordAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try{

            UsernamePasswordAuthReq authRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernamePasswordAuthReq.class);

            // Reads the request InputStream and maps it to the UsernamePasswordAuthRequest (coded) class

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(), // Principle/username
                    authRequest.getPassword() // Credential
            );


            return authenticationManager.authenticate(authentication);
            // Checks if the username exits and if the password matches

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // The following method creates JWT (header, payload, signature/key)
        String key = "This_is_a_Secured_Key"; // Highly secured key
        String token = Jwts.builder()
                        .setSubject(authResult.getName()) // username
                        .claim("authorities", authResult.getAuthorities())
                        .setIssuedAt(new java.util.Date())
                        .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                        .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                        .compact();

        // Sending the token to the client
        response.addHeader("Authorization", "Barer "+token); // needs to be in this order (Documentation)
    }

}
