package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.exceptions.UserNotFoundException;
import com.vizhu.vizhu.model.AppUser;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Запросный контроллер (для получения информации о пользователе)
 */
@Service
@AllArgsConstructor
public class UserServiceQuery {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        List<AppUser> appUsers = userRepository.findAll();
        return appUsers.stream()
                .map(user -> new UserDto(
                        user.getUsername(),
                        user.getPassword())
                )
                .collect(Collectors.toList());
    }
    public UserDto getUserById(UUID id) {
        return userRepository.findById(id)
                .map(user -> new UserDto(
                        user.getUsername(),
                        passwordEncoder.encode(user.getPassword()))
                )
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
