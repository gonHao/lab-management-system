package com.kmust.labManagementSystem.dao;

public class UserInfo {
    private String userNm;
    private String userPwd;


    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userNm='" + userNm + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
