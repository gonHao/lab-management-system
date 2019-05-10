package com.kmust.labManagementSystem.controller.teachingManagement;

import com.kmust.labManagementSystem.dao.teachingManagementDao.TimeTablesInfo;
import com.kmust.labManagementSystem.service.TimeTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class TimeTablesController {
@Autowired
private
TimeTablesService timeTablesService;
    @RequestMapping("/timeTable")
    public String timeTable(){
        return "/timeTables/timeTable";
    }

    @RequestMapping("/findTimeTables")
    @ResponseBody
    public String[][] findTimeTables(@RequestParam String week, @RequestParam String classroom_no){
//        String week=(String) params.get("week");
//        String classroom_no=(String) params.get("classroom_no");
        System.out.println("======"+week);
        System.out.println("======"+classroom_no);
        return timeTablesService.findTimeTablesByWeek(week,classroom_no);
    }

    @RequestMapping("/findClassInfo")
    @ResponseBody
    public TimeTablesInfo findTimeTables(@RequestParam String id){
        System.out.println("课程id:"+id);
        return timeTablesService.selectById(id);
    }

    @RequestMapping("/deleteClass")
    @ResponseBody
    public String  deleteClass(@RequestParam String id){
        System.out.println("课程id:"+id);
        return timeTablesService.deleteClass(id);
    }

    @RequestMapping("/addClass")
    @ResponseBody
    public String  addClass(@RequestBody Map<String,Object> map){
        System.out.println("新增课程信息:"+map.toString());

        return timeTablesService.addClass(map);
    }
}
