package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.UserDto;
import com.vizhu.vizhu.exceptions.UserNotFoundException;
import com.vizhu.vizhu.service.UserServiceQuery;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


/**
 * Запросный контроллер (для получения информации о пользователе)
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@Log4j
public class UserQueryController {
    private final UserServiceQuery userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getListOfUsers() {
          var list = userService.getAllUsers();
          log.debug(list);
          return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        try {
            UserDto userDto = userService.getUserById(id);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
