package com.kmust.labManagementSystem.controller;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/userTest")
    public String userTest(ModelMap model){
        List<UserInfo> users = userService.findAllUserInfo();
        System.out.println("userInfo:\n"+users);
        model.addAttribute("users",users);
        return "/test";
    }
}
