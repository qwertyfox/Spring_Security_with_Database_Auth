package com.qwertyfox.encrypted_password.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtUsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    public JwtUsernamePasswordAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try{

            UsernamePasswordAuthRequest authRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernamePasswordAuthRequest.class);

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
}
