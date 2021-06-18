package com.example.demo.api;

import com.example.demo.model.AuthenticateRequest;
import com.example.demo.model.AuthenticateResponse;
import com.example.demo.service.PersonService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(path = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Credentials");
        }
        UserDetails userDetails = personService.loadUserByUsername(authenticateRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(token));
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello";
    }

    /*@RequestMapping(name = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Credentials");
        }

        UserDetails userDetails = personService.loadUserByUsername(authenticateRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(token));
    }*/
}
