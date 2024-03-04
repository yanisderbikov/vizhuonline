package com.vizhu.vizhu.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class HomeController {
    @GetMapping()
    public String homepage(){
        log.debug(this.getClass());
        return "redirect:https://vizhu.online";
    }
}
