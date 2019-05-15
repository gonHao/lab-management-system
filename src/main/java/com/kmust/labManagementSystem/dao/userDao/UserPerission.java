package com.kmust.labManagementSystem.dao.userDao;

import java.util.List;

/**
 * 管理员可查看的用户信息
 */
public class UserPerission {
    private String userNm;//用户名
    private String name;//真实姓名
    private String createDate;//账号创建日期
    private String userType;//用户类型
    private String state;//用户状态
    private String note;//角色描述
    private List<String> userModule;//拥有权限

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getUserModule() {
        return userModule;
    }

    public void setUserModule(List<String> userModule) {
        this.userModule = userModule;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserPerission{" +
                "userNm='" + userNm + '\'' +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", userType='" + userType + '\'' +
                ", state='" + state + '\'' +
                ", note='" + note + '\'' +
                ", userModule=" + userModule +
                '}';
    }
}
