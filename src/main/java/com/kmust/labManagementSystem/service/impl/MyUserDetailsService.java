package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.UserInfo;
import com.kmust.labManagementSystem.service.UserPermService;
import com.kmust.labManagementSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private UserPermService userPermService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询该用户对应权限
        List<String> list = userPermService.selectByUserNm(username);
        Collection<? extends GrantedAuthority> roleCodes = list.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        logger.info("用户名："+username);
        //查询该用户信息
        UserInfo userInfo = userService.selectByUserNm(username);
        String password  =  userInfo.getUserPwd();
        logger.info("数据库密码："+password);
        return new User(username,password,
//                true,true,true,true,
                roleCodes);
//                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin"));
    }
}
