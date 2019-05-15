package com.kmust.labManagementSystem.dao.classBasisInfo;

public class CheckRecord {
    private String id;//记录id
    private String week;//检查周
    private String classRoomNo;//教室编号
    private String classRoomName;//实验室名称
    private String state;//状态
    private String date;//检查日期
    private String checkMan;//检查人
    private String note;//备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(String classRoomNo) {
        this.classRoomNo = classRoomNo;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CheckRecord{" +
                "id='" + id + '\'' +
                ", week='" + week + '\'' +
                ", classRoomNo='" + classRoomNo + '\'' +
                ", classRoomName='" + classRoomName + '\'' +
                ", state='" + state + '\'' +
                ", date='" + date + '\'' +
                ", checkMan='" + checkMan + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
