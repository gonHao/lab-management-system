package com.kmust.labManagementSystem.mapper.teachingManagementMapper;

import com.kmust.labManagementSystem.dao.teachingManagementDao.ClassProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ClassProjectMapper {
    int insertProject(ClassProject classProject);
    List<ClassProject>  selectByCourseName(@Param("courseName") String courseName);
    int updateByCourseNo(ClassProject classProject);
    int deleteByCourseNo(String courseNo);
}
