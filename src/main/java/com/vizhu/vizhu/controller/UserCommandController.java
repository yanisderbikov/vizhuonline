package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.dto.SignUpRequest;
import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.service.UserServiceCommand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserCommandController {
    private final UserServiceCommand userService;

    @PutMapping("/update")
    public ResponseEntity<UserDtoResponse> updateUser(@Valid @RequestBody SignUpRequest request){
        UserDtoResponse dto = userService.updateUser(request);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
