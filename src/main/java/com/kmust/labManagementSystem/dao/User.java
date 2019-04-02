package com.kmust.labManagementSystem.dao;

public class User {
    private String userId;
    private String userNm;
    private String userPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
