package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.exceptions.domain.UserNotFoundException;
import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/** Запросный контроллер (для получения информации о пользователе) */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceQuery {
    private final UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository
            .findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

    public UserDtoResponse getUserById(UUID id) throws UserNotFoundException{
        User user = requireById(id);
        return new UserDtoResponse(user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public User requireById(UUID id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
