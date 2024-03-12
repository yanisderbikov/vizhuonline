package com.vizhu.vizhu.service;

import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

// TODO: 07/03/24 Реализовать хэширование пароля

@Service
@AllArgsConstructor
@Log4j
public class UserServiceCommand {
    private final UserRepository userRepository;

    public void createUser(User user) {
        log.debug(user);
        userRepository.save(user);
    }

    public boolean updateUser(UUID id, User userUpdate) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            log.debug("User before update: " + user);
            user.setName(userUpdate.getName());
            user.setPassword(userUpdate.getPassword());
            userRepository.save(user);
            log.debug("User after update: " + user);
            return true;
        } else {
            return false;
        }
    }
}
