package com.vizhu.vizhu.service;

import com.vizhu.vizhu.model.AppUser;
import com.vizhu.vizhu.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceQuery {
    private final UserRepository userRepository;

    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }
}
