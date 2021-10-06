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
    public String getSchedule(@RequestParam Integer uid, String leftTime, String rightTime){

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
    @PostMapping("/addSchedule")
    public String addSchedule(@RequestParam Integer uid,Schedule schedule){
        //?schedule类实例本身就有uid，不需传值uid?
        //将日程添加到数据库
        ErrorCode addResult = scheduleService.addSchedule(schedule);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        //日程插入错误或日期反向
        switch (addResult){
            case ADDSCHEDULE_FAIL_EXIST:
                result.put("ErrorCode",1);
                result.put("Descript","添加失败，日期ID已存在");
            case ADDSCHEDULE_FAIL_INSER :
                result.put("ErrorCode",1);
                result.put("Descript","添加失败，插入数据库失败");
            case ADDSCHEDULE_FAIL_DATAWRONG :
                result.put("ErrorCode",1);
                result.put("Descript","添加失败，结束日期早于开始日期");
            case ADDSCHEDULE_SUCCESS :
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
    @PostMapping("/modifySchedule")
    public String modifySchedule(@RequestParam Integer dateId, Schedule schedule){

        ErrorCode updateResult = scheduleService.updateSchedule(dateId,schedule);
        //查看修改完后的数据库id对应日程
        Schedule modifiedSchedule = scheduleService.getScheduleById(dateId);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        switch (updateResult){
            case MODIFY_FAIL_NULL:
                result.put("ErrorCode",1);
                result.put("Schedule",modifiedSchedule);
                result.put("Descript","修改失败，目标日程为空");
            case MODIFY_FAIL_UPDATE:
                result.put("ErrorCode",1);
                result.put("Schedule",modifiedSchedule);
                result.put("Descript","修改失败，更新数据库失败");
            case MODIFY_SUCCESS:
                result.put("ErrorCode",0);
                result.put("Descript","修改成功");
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
    @PostMapping("/deleteSchedule")
    public String deleteSchedule(@RequestParam Integer dateId){

        ErrorCode delResult = scheduleService.deleteScheduleById(dateId);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        switch (delResult){
            case DELSCHEDULE_FAIL_NULL:
                result.put("ErrorCode",1);
                result.put("Descript","删除失败，目标日程为空");
            case DELSCHEDULE_FAIL_DELETE:
                result.put("ErrorCode",1);
                result.put("Descript","删除失败，删除数据失败");
            case DELSCHEDULE_SUCCESS:
                result.put("ErrorCode",0);
                result.put("Descript","删除成功");
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
    @PostMapping("/dateQueryWithId")
    public String dateQueryWithId(@RequestParam Integer dateId){

        Schedule schedule = null;
        schedule = scheduleService.getScheduleById(dateId);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(schedule==null){
            result.put("ErrorCode",1);
            result.put("Descript","找不到该日程");
        }
        else {
            result.put("ErrorCode",0);
            result.put("Schedule",schedule);
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;


    }
}
