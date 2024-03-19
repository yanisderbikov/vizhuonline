package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.SignUpRequest;
import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.exceptions.domain.UserNotFoundException;
import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/** Командный контроллер (для создания и обновления пользователя) */
@Service
@AllArgsConstructor
@Transactional
public class UserServiceCommand {
    private final UserRepository userRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDtoResponse updateUser(SignUpRequest update) {
        var user =
            userRepository
                .findByEmail(update.getEmail())
                .orElseThrow(
                    () -> new UserNotFoundException("User not found with email: " + update.getEmail()));

        user.setFirstName(update.getFirstName());
        user.setLastName(update.getLastName());
        user.setRole(user.getRole());
        user.setEmail(update.getEmail());
        user.setPassword(update.getPassword());
        userRepository.save(user);
        return new UserDtoResponse(user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
