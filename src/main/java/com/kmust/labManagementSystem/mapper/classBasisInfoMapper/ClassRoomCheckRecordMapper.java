package com.kmust.labManagementSystem.mapper.classBasisInfoMapper;

import com.kmust.labManagementSystem.dao.classBasisInfo.CheckRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClassRoomCheckRecordMapper {
    /**
     * 新增检查记录
     * @param checkRecord
     * @return
     */
    int insertRecord(CheckRecord checkRecord);

    /**
     * 查询教室检查记录
     * @param classroomName
     * @return
     */
    List<CheckRecord> selectByClassroomName(@Param("classroomName") String classroomName);

    /**
     * 根据id删除选择记录
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);
}
