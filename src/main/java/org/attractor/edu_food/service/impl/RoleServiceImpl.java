package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.model.Role;
import org.attractor.edu_food.repository.RoleRepository;
import org.attractor.edu_food.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getDefaultUserRole() {
        log.info("Retrieving default user role");
        return roleRepository.findByRole("USER")
                .orElseThrow(() -> new RuntimeException("Default role USER not found"));
    }
}
