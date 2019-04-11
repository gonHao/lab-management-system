package com.kmust.labManagementSystem.service;


import java.util.List;

public interface UserPermService {
    List<String> selectByUserNm(String username);
}
