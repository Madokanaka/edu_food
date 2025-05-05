package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.UserDto;

public interface UserService {
    boolean existsByEmail(String email);

    void registerUser(UserDto userDto);
}
