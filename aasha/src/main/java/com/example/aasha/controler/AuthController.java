package com.example.aasha.controler;

import com.example.aasha.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aasha.dto.requests.UserLoginDTO;
import com.example.aasha.dto.responses.MessageResponse;
import com.example.aasha.dto.responses.jwtResponse;
import com.example.aasha.entity.User;
import com.example.aasha.exceptions.UserRegistrationException;
import com.example.aasha.security.jwt.JwtUtils;

@CrossOrigin(origins = "*")
@RestController

public class AuthController {

    //automatic dependency injection
    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    private User createUserFromRequest(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return newUser;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserRegistrationException("Username is already taken");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserRegistrationException("Email already in Use");
        }

        User newUser = createUserFromRequest(user);
        userRepository.save(newUser);

        return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), "User Created successfully"));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        User user = userRepository.findByUsername(request.getUsername()).orElse(null);

        return ResponseEntity.ok(new jwtResponse(jwt, user.getId(), user.getUsername(), user.getEmail(), user.getRole()));
    }

}
