package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.teachingManagementDao.TimeTablesInfo;
import com.kmust.labManagementSystem.mapper.teachingManagementMapper.TimeTablesMapper;
import com.kmust.labManagementSystem.service.TimeTablesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TimeTablesServiceImpl implements TimeTablesService {
    @Autowired
    TimeTablesMapper timeTablesMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String[][] findTimeTablesByWeek(String week, String classroom_no) {
        List<TimeTablesInfo> timeTablesInfoList = timeTablesMapper.selectByWeek(week, classroom_no);
        logger.info("课程表查询结果：" + timeTablesInfoList.toString());
        String[][] arr = new String[7][28];
        for (TimeTablesInfo info : timeTablesInfoList) {
            try {
                Integer beginLocation = getTimeLocation(info);
                Integer num = getTimeRange(info);
                if (num > 0) {
                    for (int i = 0; i < num; i++) {
                        arr[Integer.parseInt(info.getDay()) - 1][beginLocation + i] = info.getProfClassNo() + info.getTeacherNo() + "@" + info.getId();
                    }
                } else {
                    arr[Integer.parseInt(info.getDay()) - 1][beginLocation] = info.getProfClassNo() + info.getTeacherNo();
                }

            } catch (ParseException e) {
                logger.error("课程表数组插入出现异常");
                e.printStackTrace();
            }
        }
        logger.info("返回数组：" + arr);
        return arr;
    }

    @Override
    public TimeTablesInfo selectById(String id) {
        return timeTablesMapper.selectById(id);
    }

    @Override
    public String deleteClass(String id) {
        if (timeTablesMapper.deleteClass(id) == 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String addClass(Map<String, Object> map) {
        String classroomNo = (String) map.get("classroomNo");
        String classNm = (String) map.get("classNm");
        String beginWeek = (String) map.get("beginWeek");
        String endWeek = (String) map.get("endWeek");
        String day = (String) map.get("day");
        String beginTime = (String) map.get("beginTime");
        String endTime = (String) map.get("endTime");
        String profClass = (String) map.get("profClass");
        String teacher = (String) map.get("teacher");
        int weekNum = Integer.parseInt(endWeek) - Integer.parseInt(beginWeek) + 1;
        TimeTablesInfo timeTablesInfo = new TimeTablesInfo();
        timeTablesInfo.setDay(day);
        timeTablesInfo.setClassName(classNm);
        timeTablesInfo.setBeginTime(beginTime);
        timeTablesInfo.setEndTime(endTime);
        timeTablesInfo.setClassroomNo(classroomNo);
        timeTablesInfo.setProfClassNo(profClass);
        timeTablesInfo.setTeacherNo(teacher);
        for (int i = 1; i <= weekNum; i++) {
            timeTablesInfo.setWeek(beginWeek);
            try {
                if (judgeClassExist(timeTablesInfo)) {
                    if (timeTablesMapper.addClass(timeTablesInfo) != 1) {
                        return "第" + beginWeek + "周及以后更新失败";
                    }
                } else {
                    return "第" + beginWeek + "周内有课程冲突，无法新增课程";
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return "后台异常";
            }

            beginWeek = (Integer.parseInt(beginWeek) + 1) + "";
        }
        return "更新成功";
    }

    /**
     * 判断课程是否已存在
     *
     * @param timeTablesInfo
     * @return
     * @throws ParseException
     */
    public Boolean judgeClassExist(TimeTablesInfo timeTablesInfo) throws ParseException {
        DateFormat df = new SimpleDateFormat("HH:mm");
        long addBeginTime = df.parse(timeTablesInfo.getBeginTime()).getTime()+1;
        long addEndTime = df.parse(timeTablesInfo.getEndTime()).getTime()-1;
        List<TimeTablesInfo> timeTablesList = timeTablesMapper.findClassInfoList(timeTablesInfo);
        if (timeTablesList.size() > 0) {
            for (TimeTablesInfo t : timeTablesList) {
                long tBeginTime = df.parse(t.getBeginTime()).getTime();
                long tEndTime = df.parse(t.getEndTime()).getTime();
                if ((tBeginTime < addBeginTime && addBeginTime < tEndTime)
                        || (tBeginTime < addEndTime && addEndTime < tEndTime)
                        || (addBeginTime > tBeginTime && tEndTime < addEndTime)) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;

    }

    /**
     * 计算课程时间在课程表中显示位置
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public Integer getTimeLocation(TimeTablesInfo time) throws ParseException {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date beginTime = df.parse(time.getBeginTime());
        Integer location = (int) (beginTime.getTime() - df.parse("8:00").getTime()) / (1000 * 60 * 30);
        System.out.println("课程开始位置：" + location);
        return location;
    }

    /**
     * 计算课程表中课程一个占多少格子
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public Integer getTimeRange(TimeTablesInfo time) throws ParseException {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date beginTime = df.parse(time.getBeginTime());
        Date endTime = df.parse(time.getEndTime());
        long diff = endTime.getTime() - beginTime.getTime();
        Integer num = (int) diff / (1000 * 60 * 30);
        System.out.println("课程范围：" + num);
        return num;
    }
}

