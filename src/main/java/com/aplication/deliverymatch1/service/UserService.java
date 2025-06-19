package com.aplication.deliverymatch1.service;

import com.aplication.deliverymatch1.dto.UserDto;
import com.aplication.deliverymatch1.entity.Role;
import com.aplication.deliverymatch1.entity.User;
import com.aplication.deliverymatch1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void saveUser(UserDto userDto) {
        if (emailExists(userDto.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());

        userRepository.save(user);
    }

    public boolean login(String email, String rawPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (!userOpt.isPresent()) {
            return false;
        }

        User user = userOpt.get();
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
