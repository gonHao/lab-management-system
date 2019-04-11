package com.kmust.labManagementSystem.mapper.userMapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserPerissionMapper {
    List<String> selectByUserNm(@Param("username") String username);
}
