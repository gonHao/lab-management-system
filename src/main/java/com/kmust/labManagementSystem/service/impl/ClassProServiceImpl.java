package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.teachingManagementDao.ClassProject;
import com.kmust.labManagementSystem.mapper.teachingManagementMapper.ClassProjectMapper;
import com.kmust.labManagementSystem.service.ClassProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassProServiceImpl implements ClassProService {
    @Autowired
    private ClassProjectMapper classProjectMapper;

    @Override
    public List<ClassProject> selectByCourseName(String courseName) {
        return classProjectMapper.selectByCourseName(courseName);
    }

    @Override
    public boolean deleteClassPro(String[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                String courseNo = arr[i];
                if (classProjectMapper.deleteByCourseNo(courseNo) != 1) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;

    }

    @Override
    public boolean updateClassPro(ClassProject classProject) {
        if(classProjectMapper.updateByCourseNo(classProject)==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean addClassPro(ClassProject classProject) {
        if(classProjectMapper.insertProject(classProject)==1){
            return true;
        }
        return false;
    }

}
