package com.kmust.labManagementSystem.dao.teachingManagementDao;

public class ClassProject {
    private String courseNo;//课程号
    private String courseType;//课程类型
    private String courseName;//课程名字
    private String courseClass;//上课班级
    private String studentNum;//上课人数

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "ClassProject{" +
                "courseNo='" + courseNo + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseClass='" + courseClass + '\'' +
                ", studentNum='" + studentNum + '\'' +
                '}';
    }
}
