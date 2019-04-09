package com.kmust.labManagementSystem.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAdminController {
    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }
}
