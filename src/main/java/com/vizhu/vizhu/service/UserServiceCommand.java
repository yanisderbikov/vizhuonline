package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.model.AppUser;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
@Log4j
public class UserServiceCommand {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        log.debug(userDto);
        AppUser appUser = new AppUser();
        appUser.setName(userDto.getName());
        appUser.setPassword(userDto.getPassword()); // Здесь должно быть шифрование пароля
        userRepository.save(appUser);
    }

    // Методы для получения и обновления пользователя
}
