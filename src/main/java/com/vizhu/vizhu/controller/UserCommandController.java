package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.service.UserServiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Командный контроллер (для создания и обновления пользователя)
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserCommandController {

    private final UserServiceCommand userServiceCommand;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        userServiceCommand.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Методы для обновления пользователя
}
