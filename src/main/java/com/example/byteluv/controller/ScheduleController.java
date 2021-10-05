package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.byteluv.pojo.Schedule;
import com.example.byteluv.service.ScheduleService;
import com.example.byteluv.util.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @Author MrWang98
 * @Date 2021/9/22 15:15
 **/
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @ResponseBody
    @PostMapping("/dateQueryWithPeriod")
    public String getSchdule(@RequestParam Integer uid, String leftTime, String rightTime){

        List<Schedule> schedules = scheduleService.getScheduleByUidPeriod(uid,leftTime,rightTime);

        Map<String,Object> result = new HashMap<>();
        if(schedules==null){
            result.put("ErrorCode",1);
            result.put("Descript","查询失败");
        }else{
            result.put("ErrorCode",0);
            result.put("Date",schedules);
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;

    }

    @ResponseBody
    @PostMapping("/addSchdule")
    public String addSchdule(@RequestParam Integer uid,@RequestParam Schedule schedule){

        //将日程添加到数据库
        ErrorCode addResult = scheduleService.addSchedule(schedule);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        //日程插入错误或日期反向
        if(addResult==ErrorCode.ADDSCHEDULE_FAIL_INSER){
            result.put("ErrorCode",1);
            result.put("Descript","添加失败，插入数据库失败");
        }else if(addResult==ErrorCode.ADDSCHEDULE_FAIL_DATAWRONG){
            result.put("ErrorCode",1);
            result.put("Descript","添加失败，结束日期早于开始日期");
        }else {
            result.put("ErrorCode",0);
            result.put("DateId",schedule.getId());
            result.put("Descript","添加成功");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
    }

    @ResponseBody
    @PostMapping("/modifySchdule")
    public String modifySchdule(@RequestParam Integer dateId,@RequestParam Schedule schedule){
        return "undo";
    }

    @ResponseBody
    @PostMapping("/deleteSchdule")
    public String deleteSchdule(@RequestParam Integer dateId){
        return "undo";
    }

    @ResponseBody
    @PostMapping("/dateQueryWithId")
    public String dateQueryWithId(@RequestParam Integer dateId){
        return "undo";
    }
}
