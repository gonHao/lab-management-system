package com.kmust.labManagementSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
    @RequestMapping("/index")
    public String hi() {
        return "/index";
    }
}
