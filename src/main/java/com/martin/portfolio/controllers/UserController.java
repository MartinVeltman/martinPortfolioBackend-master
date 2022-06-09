package com.martin.portfolio.controllers;

import com.github.lambdaexpression.annotation.EnableRequestBodyParam;
import com.github.lambdaexpression.annotation.RequestBodyParam;
import com.martin.portfolio.models.User;
import com.martin.portfolio.payload.request.LoginRequest;
import com.martin.portfolio.payload.request.SignupRequest;
import com.martin.portfolio.payload.response.JwtResponse;
import com.martin.portfolio.payload.response.MessageResponse;
import com.martin.portfolio.security.jwt.AuthTokenFilter;
import com.martin.portfolio.security.jwt.JwtUtils;
import com.martin.portfolio.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableRequestBodyParam
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthTokenFilter authTokenFilter;

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @PostMapping("/user/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/user/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        user.setRole("ADMIN");
        userService.saveUser(user);
        return MessageResponse.generateResponse("Account succesvol aangemaakt", HttpStatus.OK, null);
    }


}
