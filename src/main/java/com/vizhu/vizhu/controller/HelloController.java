package com.vizhu.vizhu.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        log.debug(this.getClass());
        return "hello";
    }
}
