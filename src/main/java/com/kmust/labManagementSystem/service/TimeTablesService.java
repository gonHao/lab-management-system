package com.kmust.labManagementSystem.service;


import com.kmust.labManagementSystem.dao.teachingManagementDao.TimeTablesInfo;

import java.util.Map;

public interface TimeTablesService {
    /**
     * 根据传入数据查询
     * @return
     */
    String[][] findTimeTablesByWeek(String week,String classroom_no);

    /**
     * 根据id查询对应课程信息
     * @param id
     * @return
     */
    TimeTablesInfo selectById(String id);

    /**
     * 根据id删除对应课程
     * @param id
     * @return
     */
    String  deleteClass(String id);

    /**
     * 新增课程
     * @param map
     * @return
     */
    String addClass(Map<String,Object> map);
}
