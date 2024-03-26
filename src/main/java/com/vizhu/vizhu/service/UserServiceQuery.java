package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.exceptions.domain.UserNotFoundException;
import com.vizhu.vizhu.repo.User;
import com.vizhu.vizhu.repo.jpa.ClientRepository;
import com.vizhu.vizhu.repo.jpa.StaffRepository;
import com.vizhu.vizhu.repo.jpa.TaroterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/** Запросный контроллер (для получения информации о пользователе) */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserServiceQuery {
    private final ClientRepository clientRepository;
    private final StaffRepository staffRepository;
    private final TaroterRepository taroterRepository;

    public User findByLogin(String login) {
        var client = clientRepository.findByLogin(login);
        if (client.isPresent()){
            return client.get();
        }
        var taroter = taroterRepository.findByLogin(login);
        if (taroter.isPresent()){
            return taroter.get();
        }
        var staff = staffRepository.findByLogin(login);
        if (staff.isPresent()){
            return staff.get();
        }
        throw new UserNotFoundException("User not found with login: " + login);
    }

    public UserDtoResponse getUserById(UUID id) throws UserNotFoundException{
        User user = requireById(id);
        return new UserDtoResponse(user.getFirstName(), user.getLogin());
    }

    public User requireById(UUID id) {
        var client = clientRepository.findById(id);
        if (client.isPresent()){
            return client.get();
        }
        var taroter = taroterRepository.findById(id);
        if (taroter.isPresent()){
            return taroter.get();
        }
        var staff = staffRepository.findById(id);
        if (staff.isPresent()){
            return staff.get();
        }
        throw new UserNotFoundException("User not found with id: " + id);
    }
}
