package com.kmust.labManagementSystem.mapper;

import com.kmust.labManagementSystem.dao.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
     UserInfo selectByUserNm(String username);
     List<UserInfo> findAllUserInfo();
}
