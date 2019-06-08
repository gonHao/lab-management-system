package com.kmust.labManagementSystem.controller;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/userTest")
    public String userTest(ModelMap model){
        List<UserInfo> users = userService.findAllUserInfo();
        System.out.println("userDao:\n"+users);
        model.addAttribute("users",users);
        return "/test";
    }

    @RequestMapping("/pwd")
    public String hi() {
        return "/updatePwd";
    }

    @RequestMapping(value = "/updatePwd",method = RequestMethod.GET)
    @ResponseBody
    public String updatePwd(@RequestParam("pwd1") String pwd1){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        String userPwd = passwordEncoder.encode(pwd1);
        System.out.println(pwd1);
        System.out.println(userPwd);
        if(userService.updatePwd(username,userPwd)){
            return "修改成功 ";
        }

        return "修改失败";
    }
}
