package com.kmust.labManagementSystem.controller.adminController;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.dao.userDao.UserPerission;
import com.kmust.labManagementSystem.service.UserPermService;
import com.kmust.labManagementSystem.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PermissionCollection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserAdminController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy =  new DefaultRedirectStrategy();
    @Autowired
    UserPermService userPermService;
    @Autowired
    UserService userService;

    /**
     * 登录跳转页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }

    /**
     * /用户权限跳转页面
     * @return
     */
    @RequestMapping("/userPermAdmin")
    public String userPermAdmin(){
        return "/userPermAdmin/userPermAdmin";
    }

    @RequestMapping(value = "/findUsers",method=RequestMethod.POST)
    public  String findUsers(Model model,@RequestBody UserInfo userInfo){
        System.out.println("userInfo:"+userInfo);
        Map<String,String> map = new HashMap<>();
        map.put("userNm",userInfo.getUserNm());
        map.put("name",userInfo.getName());
        map.put("createDate",userInfo.getCreateDate());
        map.put("note",userInfo.getNote());
        List<UserPerission> userPerissionList =  userPermService.findUserPerm(map);
        model.addAttribute("users",userPerissionList);

        logger.info("管理员用户查询返回信息：");
        for(UserPerission u:userPerissionList){
            logger.info(u.toString()+"\t");
        }
        return "/userPermAdmin/userPermAdmin::table_refresh";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody UserPerission formDate){
        try {
            if(userService.addUser(formDate)&&userPermService.addUserPermission(formDate)){
                logger.info("新增用户成功");
                return "新增用户信息成功";
            }else {
                return "新增失败";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "服务器异常 ";
        }
    }


    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String requireAuthention(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest!=null){
            String target =savedRequest.getRedirectUrl();
            if(StringUtils.endsWithIgnoreCase(target,".html")){
                redirectStrategy.sendRedirect(request,response,"/login");
            }
        }
        return "需要身份认证";
    }



}

