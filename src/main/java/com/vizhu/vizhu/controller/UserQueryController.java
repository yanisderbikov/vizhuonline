package com.vizhu.vizhu.controller;

import com.vizhu.vizhu.model.AppUser;
import com.vizhu.vizhu.service.UserServiceCommand;
import com.vizhu.vizhu.service.UserServiceQuery;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    public List<AppUser> getListOfUsers() {
          var list = userService.getAllUsers();
          log.debug(list);
          return list;
    }
}
