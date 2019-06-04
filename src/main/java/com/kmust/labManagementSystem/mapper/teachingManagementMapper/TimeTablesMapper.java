package com.kmust.labManagementSystem.mapper.teachingManagementMapper;

import com.kmust.labManagementSystem.dao.teachingManagementDao.TimeTablesInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TimeTablesMapper {
    List<TimeTablesInfo> selectByWeek(@Param("week") String week, @Param("classroom_no")String classroom_no);
    TimeTablesInfo selectById(@Param("id") String id);
    int deleteClass(@Param("id") String id);
    int addClass(TimeTablesInfo timeTablesInfo);
    List<TimeTablesInfo>  findClassInfoList(TimeTablesInfo timeTablesInfo);
    List<TimeTablesInfo> selectByClassroomNo(@Param("classroomNo") String classroomNo);
}
