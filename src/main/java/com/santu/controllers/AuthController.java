package com.santu.controllers;

import com.santu.dto.request.LoginRequest;
import com.santu.dto.response.LoginResponse;
import com.santu.dto.request.SignupRequest;
import com.santu.entities.User;
import com.santu.services.interfac.AuthService;
import com.santu.services.jwt.UserServiceImpl;
import com.santu.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.POST})
@RestController
@RequestMapping("/")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final AuthService authService;
    private final UserServiceImpl userService;

    private final JwtUtil jwtUtil;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AuthService authService, UserServiceImpl userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        User createdUser = authService.createUser(signupRequest);
        if(createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        } else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
        }
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect email or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer is not activated");
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
        }

        // Generate JWT token
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        // Send response with JWT token
        return ResponseEntity.ok(new LoginResponse(jwt));
    }






}
