package com.kmust.labManagementSystem.controller.adminController;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.mapper.UserMapper;
import com.kmust.labManagementSystem.service.UserPermService;
import com.kmust.labManagementSystem.service.UserService;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAdminController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    UserPermService userPermService;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    /**
     * 登录跳转页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login.html";
    }

    /**
     * /用户权限跳转页面
     *
     * @return
     */
    @RequestMapping("/userPermAdmin")
    public String userPermAdmin() {
        return "/userPermAdmin/userPermAdmin";
    }

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<UserPerission> findUsers(@RequestParam String userNm, String name, String createDate, String note) {
        Map<String, String> map = new HashMap<>();
        map.put("userNm", userNm);
        map.put("name", name);
        map.put("createDate", createDate);
        map.put("note", note);
        List<UserPerission> userPerissionList = userPermService.findUserPerm(map);
//        model.addAttribute("users",userPerissionList);

        logger.info("管理员用户查询返回信息：");
        for (UserPerission u : userPerissionList) {
            logger.info(u.toString() + "\t");
        }
        return userPerissionList;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody UserPerission formDate) {
        try {
            if (userService.addUser(formDate) && userPermService.addUserPermission(formDate)) {
                logger.info("新增用户成功");
                return "新增用户信息成功";
            } else {
                return "新增失败";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "服务器异常 ";
        }
    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public String deleteUsers(@RequestBody String[] arr) {
        System.out.println("进入删除操作：" + arr[0]);
        if (userPermService.deleteUsers(arr)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody UserPerission formDate) {
        logger.info("========进入修改用户信息界面=====");
        if (userPermService.updateUsers(formDate)) {
            return "修改用户信息成功";
        }
        return "修改用户信息失败";
    }

    /**
     * 登录时查询登录用户信息
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserPerission getUserInfo() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        List<String>  roleList = userPermService.selectByUserNm(username);
        UserInfo userInfo = userMapper.selectByUserNm(username);
        UserPerission userPerission  = new UserPerission();
        userPerission.setUserNm(userInfo.getUserNm());
        userPerission.setCreateDate(userInfo.getCreateDate());
        userPerission.setName(userInfo.getName());
        userPerission.setState(userInfo.getState());
        userPerission.setUserType(userInfo.getUserType());
        userPerission.setNote(userInfo.getNote());
        userPerission.setUserModule(roleList);
        return userPerission;
    }

    @RequestMapping(value = "/addUsersByExcel", method = RequestMethod.POST)
    @ResponseBody
    public String addUsersByExcel(@RequestParam("file") MultipartFile mFile) throws IOException {
        System.out.println("根据文件新增用户");
        return userPermService.addUsersByExcel(mFile);

    }


    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String requireAuthention(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                redirectStrategy.sendRedirect(request, response, "/login");
            }
        }
        return "需要身份认证";
    }


}

