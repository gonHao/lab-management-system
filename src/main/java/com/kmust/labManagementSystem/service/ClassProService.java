package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.teachingManagementDao.ClassProject;

import java.util.List;

public interface ClassProService {
    /**
     * 根据 课程名称查询信息
     * @param courseName
     * @return
     */
    List<ClassProject> selectByCourseName(String courseName);

    /**
     * 批量删除
     * @param arr
     * @return
     */
    boolean deleteClassPro(String[] arr);

    /**
     * 更新课程信息
     * @param classProject
     * @return
     */
    boolean updateClassPro(ClassProject classProject);

    /**
     * 新增课程信息
     * @param classProject
     * @return
     */
    boolean addClassPro(ClassProject classProject);
}
