package com.aplication.deliverymatch1.controller;

import com.aplication.deliverymatch1.dto.UserDto;
import com.aplication.deliverymatch1.entity.User;
import com.aplication.deliverymatch1.repository.UserRepository;
import com.aplication.deliverymatch1.service.UserService;
import com.aplication.deliverymatch1.util.JwtUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          UserRepository userRepository,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userService.saveUser(userDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto) {
        String email = userDto.getEmail();
        String password = userDto.getPassword();

        System.out.println("Tentative login pour email: " + email);

        return userRepository.findByEmail(email)
                .map(user -> {
                    System.out.println("Utilisateur trouvé: " + user.getEmail());
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        String token = jwtUtil.generateToken(user.getEmail());
                        return ResponseEntity.ok(Map.of(
                                "token", token,
                                "user", user
                        ));
                    } else {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body("Invalid password");
                    }
                })
                .orElseGet(() -> {
                    System.out.println("Utilisateur non trouvé");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body("User not found");
                });
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logged out successfully");
    }
    @PutMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non authentifié");
        }

        String email;
        if (authentication.getPrincipal() instanceof UserDetails) {
            email = ((UserDetails) authentication.getPrincipal()).getUsername();
        } else {
            email = authentication.getPrincipal().toString();
        }

        return userRepository.findByEmail(email).map(user -> {
            if (userDto.getEmail() != null && !userDto.getEmail().equals(user.getEmail())) {
                if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Cet email est déjà utilisé");
                }
                user.setEmail(userDto.getEmail());
            }

            if (userDto.getFirstName() != null) {
                user.setFirstName(userDto.getFirstName());
            }

            if (userDto.getLastName() != null) {
                user.setLastName(userDto.getLastName());
            }

            if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }

            if (userDto.getRole() != null) {
                // Assure-toi de gérer correctement le rôle (majuscule ?)
                user.setRole(userDto.getRole());
            }

            userRepository.save(user);
            return ResponseEntity.ok("Profil mis à jour avec succès");
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur non trouvé"));
    }
}
