package com.kmust.labManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @RequestMapping("/index")
    public String hi() {
        return "/index";
    }

    @RequestMapping("/test")
    public String test(){
        return "/test";
    }

}
