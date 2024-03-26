package com.vizhu.vizhu.service;

import com.vizhu.vizhu.dto.SignUpRequest;
import com.vizhu.vizhu.dto.UserDtoResponse;
import com.vizhu.vizhu.repo.User;
import com.vizhu.vizhu.repo.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/** Командный контроллер (для создания и обновления пользователя) */
@Service
@AllArgsConstructor
@Transactional
public class UserServiceCommand {
    private final UserRepository userRepository;
    private final UserServiceQuery userServiceQuery;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDtoResponse updateUser(SignUpRequest update) {
        var user = userServiceQuery.findByLogin(update.getLogin());
        user.setFirstName(update.getFirstName());
        user.setLogin(update.getLogin());
        user.setPassword(update.getPassword());
        userRepository.save(user);
        return new UserDtoResponse(user.getFirstName(), user.getLogin());
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
