package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.service.UserServiceQuery;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Запросный контроллер (для получения информации о пользователе)
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Log4j
public class UserQueryController {
    private final UserServiceQuery userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable UUID id) {
        UserDtoResponse userDtoResponse = userService.getUserById(id);
        return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
    }
}
