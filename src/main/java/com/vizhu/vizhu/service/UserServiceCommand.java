package com.vizhu.vizhu.service;

import com.vizhu.vizhu.model.AppUser;
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

    public void createUser(AppUser appUser) {
        log.debug(appUser);
        userRepository.save(appUser);
    }

    public boolean updateUser(UUID id, AppUser appUserUpdate) {
        Optional<AppUser> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            AppUser appUser = userOptional.get();
            log.debug("User before update: " + appUser);
            appUser.setUsername(appUserUpdate.getUsername());
            appUser.setPassword(appUserUpdate.getPassword());
            userRepository.save(appUser);
            log.debug("User after update: " + appUser);
            return true;
        } else {
            return false;
        }
    }
}
