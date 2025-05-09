package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.UserDto;
import org.attractor.edu_food.exceptions.DatabaseOperationException;
import org.attractor.edu_food.exceptions.RecordAlreadyExistsException;
import org.attractor.edu_food.exceptions.UserNotFoundException;
import org.attractor.edu_food.model.Role;
import org.attractor.edu_food.model.User;
import org.attractor.edu_food.repository.UserRepository;
import org.attractor.edu_food.service.RoleService;
import org.attractor.edu_food.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    @Override
    public boolean existsByEmail(String email) {
        log.info("Checking whether user exists by Email or not");
        return userRepository.existsByEmail(email);
    }

    @Override
    public void registerUser(UserDto userDto) {
        log.info("Registering user: {}", userDto.getEmail());

        System.out.println("Registering user: " + userDto.getEmail() + " " + userDto.getPassword());

        if (userRepository.existsByEmail(userDto.getEmail().strip())) {
            throw new RecordAlreadyExistsException("User with this email already exists");
        }

        Role userRole = roleService.getDefaultUserRole();

        User user = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role("USER")
                .roles(List.of(userRole))
                .build();

        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Error saving user", e);
            throw new DatabaseOperationException("Error creating user");
        }
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found: " + email));
    }
}
