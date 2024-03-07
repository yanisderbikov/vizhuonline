package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.service.UserServiceCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        boolean isUpdated = userService.updateUser(id, userDto);
        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
