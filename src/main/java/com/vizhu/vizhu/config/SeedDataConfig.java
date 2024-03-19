package com.vizhu.vizhu.config;

import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.model.Role;
import com.vizhu.vizhu.repo.UserRepository;
import com.vizhu.vizhu.service.UserServiceCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SeedDataConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserServiceCommand userService;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            var admin = User
                    .builder()
                    .firstName("admin")
                    .lastName("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("password"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userService.save(admin);
        }
    }
}
