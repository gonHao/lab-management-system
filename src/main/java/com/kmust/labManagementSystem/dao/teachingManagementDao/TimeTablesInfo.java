package com.kmust.labManagementSystem.dao.teachingManagementDao;

public class TimeTablesInfo {
    private int id;
    private String week;
    private String day;
    private String beginTime;
    private String endTime;
    private String profClassNo;
    private String classroomNo;
    private String teacherNo;
    private String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProfClassNo() {
        return profClassNo;
    }

    public void setProfClassNo(String profClassNo) {
        this.profClassNo = profClassNo;
    }

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "TimeTablesInfo{" +
                "id=" + id +
                ", week='" + week + '\'' +
                ", day='" + day + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", profClassNo='" + profClassNo + '\'' +
                ", classroomNo='" + classroomNo + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
