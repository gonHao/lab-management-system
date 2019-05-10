package com.kmust.labManagementSystem.mapper.userMapper;

import com.kmust.labManagementSystem.dao.userDao.UserModuleMap;
import org.springframework.stereotype.Component;

@Component
public interface UserModuleMapMapper {
    int  addMap(UserModuleMap userModuleMap);
}
