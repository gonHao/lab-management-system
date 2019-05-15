package com.kmust.labManagementSystem.mapper.userMapper;

import com.kmust.labManagementSystem.dao.userDao.UserModuleMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserModuleMapMapper {
    int  addMap(UserModuleMap userModuleMap);
    List<UserModuleMap> selectByUserNm(String userNm);
    int deleteMap(UserModuleMap userModuleMap);
}
