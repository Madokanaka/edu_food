package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.UserDto;
import org.attractor.edu_food.model.User;

public interface UserService {
    boolean existsByEmail(String email);

    void registerUser(UserDto userDto);

    User findByEmail(String email);
}
