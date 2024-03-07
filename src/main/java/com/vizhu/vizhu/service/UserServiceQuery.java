package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.exceptions.UserNotFoundException;
import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceQuery {
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getName(), user.getPassword()))
                .collect(Collectors.toList());
    }
    public UserDto getUserById(UUID id) {
        return userRepository.findById(id)
                .map(user -> new UserDto(user.getName(), user.getPassword())) // Предполагаем, что UserDto содержит конструктор с параметрами name и password
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

}
