package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.model.AppUser;
import com.vizhu.vizhu.service.UserServiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Командный контроллер (для создания и обновления пользователя)
 */

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserCommandController {

    private final UserServiceCommand userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        AppUser appUser = AppUser.builder()
                .username(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        userService.createUser(appUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        AppUser appUser = AppUser.builder()
                .username(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        boolean isUpdated = userService.updateUser(id, appUser);
        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
