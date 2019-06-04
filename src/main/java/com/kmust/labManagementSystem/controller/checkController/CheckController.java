package com.kmust.labManagementSystem.controller.checkController;

import com.kmust.labManagementSystem.dao.classBasisInfo.CheckRecord;
import com.kmust.labManagementSystem.service.CheckRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/checkInfo")
public class CheckController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CheckRecordService checkRecordService;
    @RequestMapping("/checkInfo")
    public String checkInfo(){
        return "/checkClassroom/checkRecord";
    }
    @RequestMapping(value = "/findCheckRecord", method = RequestMethod.GET)
    @ResponseBody
    public List<CheckRecord> findCheckRecord(@RequestParam String classroomName) throws ParseException {
        logger.info("查询教室检查记录："+classroomName);
        return checkRecordService.findByClassroomName(classroomName);
    }



    @RequestMapping("/addCheckInfo")
    @ResponseBody
    public String addCheckInfo(@RequestBody CheckRecord checkRecord){
        logger.info("新增检查记录："+checkRecord.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        checkRecord.setDate(df.format(new Date()));
        if(checkRecordService.addCheckClassroom(checkRecord)){
            return "新增成功";
        }
        return "新增失败";
    }

    @RequestMapping("/deleteRec")
    @ResponseBody
    public String deleteRec(@RequestBody String[] arr){
        return checkRecordService.deleteById(arr);
    }

}
