package com.vizhu.vizhu;

import com.vizhu.vizhu.model.User;
import com.vizhu.vizhu.service.UserServiceCommand;
import com.vizhu.vizhu.service.UserServiceQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VizhuApplicationTests {
    @Autowired
    UserServiceQuery userServiceQuery;
    @Autowired
    UserServiceCommand userServiceCommand;

    @Test
    void contextLoads() {

    }
    @Test
    void printAllUsers(){
        var list= userServiceQuery.getAllUsers();
        if (list.isEmpty()) throw new RuntimeException("Person doesn't added");
        System.out.println(list);
    }

    @Test
    void addPerson(){
        var random = Math.random();
        userServiceCommand.createUser(
                User.builder()
                        .name(String.format("yan %s", random))
                        .password(String.format("password %s", random))
                        .build()
        );
    }
}
