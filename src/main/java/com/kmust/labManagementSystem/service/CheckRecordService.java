package com.kmust.labManagementSystem.service;

import com.kmust.labManagementSystem.dao.classBasisInfo.CheckRecord;

import java.text.ParseException;
import java.util.List;

public interface CheckRecordService {
    /**
     * 添加需要检查教室信息
     * @param checkRecord
     * @return
     */
    boolean addCheckClassroom(CheckRecord checkRecord);

    /**
     * 根据教室名称查询记录
     * @param classroomName
     * @return
     */
    List<CheckRecord> findByClassroomName(String classroomName) throws ParseException;

    /**
     * 根据id删除记录
     * @param arr
     * @return
     */
    String deleteById(String[] arr);

    /**
     * 检查教室
     * @param id
     * @return
     */
    boolean checkClassroom(Integer id);
}
