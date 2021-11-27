package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.byteluv.VO.ScheduleItemVO;
import com.example.byteluv.pojo.Schedule;
import com.example.byteluv.pojo.ScheduleItem;
import com.example.byteluv.service.ScheduleService;
import com.example.byteluv.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.*;

/**
 * @Author MrWang98
 * @Date 2021/9/22 15:15
 **/
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    HttpServletRequest request; //这里可以获取到request

//    @ResponseBody
//    @PostMapping("/dateQueryWithPeriod")
//    public String getSchedule(@RequestParam Integer uid, String leftTime, String rightTime){
//
//        //检查是否已经登录
////        HttpSession session = request.getSession();
////        if(session.getAttribute("uid")==null){
////            return "login first";
////        }
//
//        List<Schedule> schedules = scheduleService.getScheduleByUidPeriod(uid,leftTime,rightTime);
//
//        Map<String,Object> result = new HashMap<>();
//        if(schedules==null){
//            result.put("ErrorCode",1);
//            result.put("Descript","查询失败");
//        }else{
//            result.put("ErrorCode",0);
//            result.put("Date",schedules);
//        }
//
//        //将结果转为JSON
//        String jsonString = JSON.toJSONString(result);
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);
//
//        //返回结果
//        return json;
//
//    }

//    @ResponseBody
//    @PostMapping("/addSchedule")
//    public String addSchedule(@RequestParam Integer uid,Schedule schedule){
//
//        //检查是否已经登录
////        HttpSession session = request.getSession();
////        if(session.getAttribute("uid")==null){
////            return "login first";
////        }
//
//        //?schedule类实例本身就有uid，不需传值uid?
//        //将日程添加到数据库
//        ErrorCode addResult = scheduleService.addSchedule(schedule);
//
//        //返回前端的结果
//        Map<String,Object> result = new HashMap<>();
//        //日程插入错误或日期反向
//        switch (addResult){
//            case ADDSCHEDULE_FAIL_EXIST:
//                result.put("ErrorCode",1);
//                result.put("Descript","添加失败，日期ID已存在");
//            case ADDSCHEDULE_FAIL_INSER :
//                result.put("ErrorCode",1);
//                result.put("Descript","添加失败，插入数据库失败");
//            case ADDSCHEDULE_FAIL_DATAWRONG :
//                result.put("ErrorCode",1);
//                result.put("Descript","添加失败，结束日期早于开始日期");
//            case ADDSCHEDULE_SUCCESS :
//                result.put("ErrorCode",0);
//                result.put("DateId",schedule.getId());
//                result.put("Descript","添加成功");
//        }
//
//        //将结果转为JSON
//        String jsonString = JSON.toJSONString(result);
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);
//
//        //返回结果
//        return json;
//    }

    @ResponseBody
    @PostMapping("/addScheduleItem")
    public String addScheduleItem(@RequestParam Integer uid, ScheduleItemVO scheduleItemVO){

        //检查是否已经登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("uid")==null){
//            return "login first";
//        }

        ScheduleItem scheduleItem=new ScheduleItem();
        scheduleItem.setDate(scheduleItemVO.getDate())
                .setContent(scheduleItemVO.getContent())
                .setOwnType(scheduleItemVO.getOwnType())
                .setUid(scheduleItemVO.getUid())
                .setStatusType(scheduleItemVO.getStatusType());
        //将日程添加到数据库
        ErrorCode addResult = scheduleService.addScheduleItem(scheduleItem);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        //日程插入错误或日期反向
        switch (addResult){
            case ADDSCHEDULE_FAIL_INSER :
                result.put("ErrorCode",1);
                result.put("Descript","添加失败，插入数据库失败");
                break;
            case ADDSCHEDULE_SUCCESS :
                result.put("ErrorCode",0);
                result.put("DateId",scheduleItem.getId());
                result.put("Descript","添加成功");
                break;
            default:
                result.put("ErrorCode",1);
                result.put("Descript","添加失败，未知错误");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
    }

//    @ResponseBody
//    @PostMapping("/modifySchedule")
//    public String modifySchedule(@RequestParam Integer dateId, Schedule schedule){
//        //检查是否已经登录
////        HttpSession session = request.getSession();
////        if(session.getAttribute("uid")==null){
////            return "login first";
////        }
//        ErrorCode updateResult = scheduleService.updateSchedule(dateId,schedule);
//        //查看修改完后的数据库id对应日程
//        Schedule modifiedSchedule = scheduleService.getScheduleById(dateId);
//
//        //返回前端的结果
//        Map<String,Object> result = new HashMap<>();
//
//        switch (updateResult){
//            case MODIFY_FAIL_NULL:
//                result.put("ErrorCode",1);
//                result.put("Schedule",modifiedSchedule);
//                result.put("Descript","修改失败，目标日程为空");
//            case MODIFY_FAIL_UPDATE:
//                result.put("ErrorCode",1);
//                result.put("Schedule",modifiedSchedule);
//                result.put("Descript","修改失败，更新数据库失败");
//            case MODIFY_SUCCESS:
//                result.put("ErrorCode",0);
//                result.put("Descript","修改成功");
//        }
//        //将结果转为JSON
//        String jsonString = JSON.toJSONString(result);
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);
//
//        //返回结果
//        return json;
//    }

    @ResponseBody
    @PostMapping("/modifyScheduleItem")
    public String modifyScheduleItem(@RequestParam Integer dateId, ScheduleItemVO scheduleItemVO){
        //检查是否已经登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("uid")==null){
//            return "login first";
//        }
        ScheduleItem scheduleItem=new ScheduleItem();
        scheduleItem.setDate(scheduleItemVO.getDate())
                .setContent(scheduleItemVO.getContent())
                .setOwnType(scheduleItemVO.getOwnType())
                .setUid(scheduleItemVO.getUid())
                .setStatusType(scheduleItemVO.getStatusType())
                .setId(dateId);
        ErrorCode updateResult = scheduleService.updateScheduleItem(dateId,scheduleItem);
        //查看修改完后的数据库id对应日程
        ScheduleItem modifiedScheduleItem = scheduleService.getScheduleItemById(dateId);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        switch (updateResult){
            case MODIFY_FAIL_NULL:
                result.put("ErrorCode",1);
                result.put("Schedule",modifiedScheduleItem);
                result.put("Descript","修改失败，数据库中无此id的日程");
                break;
            case MODIFY_FAIL_UPDATE:
                result.put("ErrorCode",1);
                result.put("Schedule",modifiedScheduleItem);
                result.put("Descript","修改失败，更新数据库失败");
                break;
            case MODIFY_SUCCESS:
                result.put("ErrorCode",0);
                result.put("Descript","修改成功");
                break;
            default:
                result.put("ErrorCode",1);
                result.put("Descript","修改失败，未知错误");
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
    }

//    @ResponseBody
//    @PostMapping("/deleteSchedule")
//    public String deleteSchedule(@RequestParam Integer dateId){
//
//        //检查是否已经登录
////        HttpSession session = request.getSession();
////        if(session.getAttribute("uid")==null){
////            return "login first";
////        }
//
//        ErrorCode delResult = scheduleService.deleteScheduleById(dateId);
//
//        //返回前端的结果
//        Map<String,Object> result = new HashMap<>();
//
//        switch (delResult){
//            case DELSCHEDULE_FAIL_NULL:
//                result.put("ErrorCode",1);
//                result.put("Descript","删除失败，数据库中无此id的日程");
//            case DELSCHEDULE_FAIL_DELETE:
//                result.put("ErrorCode",1);
//                result.put("Descript","删除失败，删除数据失败");
//            case DELSCHEDULE_SUCCESS:
//                result.put("ErrorCode",0);
//                result.put("Descript","删除成功");
//        }
//
//        //将结果转为JSON
//        String jsonString = JSON.toJSONString(result);
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);
//
//        //返回结果
//        return json;
//    }

    @ResponseBody
    @PostMapping("/deleteScheduleItem")
    public String deleteScheduleItem(@RequestParam Integer dateId){

        //检查是否已经登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("uid")==null){
//            return "login first";
//        }

        ErrorCode delResult = scheduleService.deleteScheduleItemById(dateId);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        switch (delResult){
            case DELSCHEDULE_FAIL_NULL:
                result.put("ErrorCode",1);
                result.put("Descript","删除失败，数据库中无此id的日程");
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

//    @ResponseBody
//    @PostMapping("/dateQueryWithId")
//    public String dateQueryWithId(@RequestParam Integer dateId){
//        //检查是否已经登录
////        HttpSession session = request.getSession();
////        if(session.getAttribute("uid")==null){
////            return "login first";
////        }
//
//        Schedule schedule = null;
//        schedule = scheduleService.getScheduleById(dateId);
//
//        //返回前端的结果
//        Map<String,Object> result = new HashMap<>();
//
//        if(schedule==null){
//            result.put("ErrorCode",1);
//            result.put("Descript","找不到该日程");
//        }
//        else {
//            result.put("ErrorCode",0);
//            result.put("Schedule",schedule);
//        }
//        //将结果转为JSON
//        String jsonString = JSON.toJSONString(result);
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);
//
//        //返回结果
//        return json;
//
//
//    }

    @ResponseBody
    @GetMapping("/getScheduleWithUserIdAndDate")
    public String getScheduleWithUserIdAndDate(@RequestParam Integer uid, @RequestParam Date date){
        //检查是否已经登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("uid")==null){
//            return "login first";
//        }

        List<ScheduleItem> scheduleItemList = null;
        scheduleItemList = scheduleService.getScheduleByUserIdAndDate(uid,date.toString());

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(scheduleItemList==null){
            result.put("ErrorCode",1);
            result.put("Descript","当天无日程");
        }
        else {
            result.put("ErrorCode",0);
            result.put("Schedule",scheduleItemList);
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
    @GetMapping("/getMonthScheduleWithUserIdAndDate")
    public String getMonthScheduleWithUserIdAndDate(@RequestParam Integer uid, @RequestParam Date date){
        //检查是否已经登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("uid")==null){
//            return "login first";
//        }

        String[] array = date.toString().split("-");
        String yearMonth = array[0]+"-"+array[1];

        List<ScheduleItem> scheduleItemList = null;
        scheduleItemList = scheduleService.getMonthScheduleByUserIdAndDate(uid,yearMonth);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(scheduleItemList==null){
            result.put("ErrorCode",1);
            result.put("Descript","当天无日程");
        }
        else {
            result.put("ErrorCode",0);
            result.put("Schedule",scheduleItemList);
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
