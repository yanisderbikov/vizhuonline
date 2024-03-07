package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

// TODO: 07/03/24 Реализовать хэширование пароля

@Service
@AllArgsConstructor
@Log4j
public class UserServiceCommand {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        log.debug(userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    public boolean updateUser(UUID id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            log.debug("User before update: " + user);
            user.setName(userDto.getName());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
            log.debug("User after update: " + user);
            return true;
        } else {
            return false;
        }
    }
}
