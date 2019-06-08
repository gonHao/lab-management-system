package com.kmust.labManagementSystem.service.impl;

import com.kmust.labManagementSystem.dao.classBasisInfo.CheckRecord;
import com.kmust.labManagementSystem.dao.teachingManagementDao.TimeTablesInfo;
import com.kmust.labManagementSystem.mapper.classBasisInfoMapper.ClassRoomCheckRecordMapper;
import com.kmust.labManagementSystem.mapper.labMapper.UserMapper;
import com.kmust.labManagementSystem.mapper.teachingManagementMapper.TimeTablesMapper;
import com.kmust.labManagementSystem.mapper.userMapper.UserModuleMapMapper;
import com.kmust.labManagementSystem.service.CheckRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CheckRecordServiceImpl implements CheckRecordService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ClassRoomCheckRecordMapper classRoomCheckRecordMapper;
    @Autowired
    private TimeTablesMapper timeTablesMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean addCheckClassroom(CheckRecord checkRecord) {
        if(classRoomCheckRecordMapper.insertRecord(checkRecord)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<CheckRecord> findByClassroomName(String classroomName) throws ParseException {
        List<CheckRecord> checkRecords = classRoomCheckRecordMapper.selectByClassroomName(classroomName);

        for(CheckRecord cr:checkRecords){
            List<TimeTablesInfo> timeTablesInfos = timeTablesMapper.selectByClassroomNo(cr.getClassRoomName());
            int times=0;
            for(TimeTablesInfo tti:timeTablesInfos){
                DateFormat df = new SimpleDateFormat("HH:mm");
                Date beginTime = df.parse(tti.getBeginTime());
                Date endTime = df.parse(tti.getEndTime());
                long diff = endTime.getTime() - beginTime.getTime();
                times = times+(int) diff / (1000 * 60);
            }
            cr.setUseTimes(Integer.toString(times)+"min");
        }
        return checkRecords;
    }


    @Override
    public String deleteById(String[] arr) {
        for(int i=0;i<arr.length;i++){
            if(classRoomCheckRecordMapper.deleteById(Integer.parseInt(arr[i]))!=1){
                return "id为"+arr[i]+"的记录删除失败";
            }
        }
        return "删除成功";
    }

    @Override
    public boolean checkClassroom(Integer id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        String checkMan =  userMapper.selectByUserNm(username).getName();
        if(checkMan==null||"".equals(checkMan)){
            return false;
        }
        SimpleDateFormat df  = new SimpleDateFormat("yyyyMMdd");
        if(classRoomCheckRecordMapper.checkClass(id,checkMan,df.format(new Date()))==1){
            return true;
        }
        return false;
    }
}
