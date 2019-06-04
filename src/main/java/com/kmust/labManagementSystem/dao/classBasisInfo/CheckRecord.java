package com.kmust.labManagementSystem.dao.classBasisInfo;

public class CheckRecord {
    private String id;//记录id
    private String classRoomName;//实验室名称
    private String useTimes;//使用时长
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

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(String useTimes) {
        this.useTimes = useTimes;
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
                ", classRoomName='" + classRoomName + '\'' +
                ", useTimes='" + useTimes + '\'' +
                ", state='" + state + '\'' +
                ", date='" + date + '\'' +
                ", checkMan='" + checkMan + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
