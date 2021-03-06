package com.example.byteluv.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.byteluv.mappers.ScheduleItemMapper;
import com.example.byteluv.mappers.ScheduleMapper;
import com.example.byteluv.pojo.Schedule;
import com.example.byteluv.pojo.ScheduleItem;
import com.example.byteluv.pojo.User;
import com.example.byteluv.service.ScheduleService;
import com.example.byteluv.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/9/29 15:01
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Autowired
    ScheduleItemMapper scheduleItemMapper;

    @Override
    public List<Schedule> getScheduleByUidPeriod(Integer uid, String leftTime, String rightTime) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        queryWrapper.ge("start_time",leftTime);
        queryWrapper.le("end_time",rightTime);
        List<Schedule> schedules = scheduleMapper.selectList(queryWrapper);
        return schedules;
    }

    @Override
    public ErrorCode addSchedule(Schedule schedule) {

        //日程是否已存在
        if(scheduleMapper.selectOne(new QueryWrapper<Schedule>().eq("id",schedule.getId()))!=null)
            return ErrorCode.ADDSCHEDULE_FAIL_EXIST;

        //判断开始日期是否早于结束日期
        if(schedule.getStartTime().isBefore(schedule.getEndTime())){
            try{
                scheduleMapper.insert(schedule);
            }catch (Exception e){
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.ADDSCHEDULE_FAIL_INSER;//插入错误
            }
        }else{
            return ErrorCode.ADDSCHEDULE_FAIL_DATAWRONG;


        }
        return ErrorCode.ADDSCHEDULE_SUCCESS;
    }


    @Override
    public ErrorCode deleteScheduleById(Integer dateId){
        if(scheduleMapper.selectOne(new QueryWrapper<Schedule>().eq("id",dateId))==null){
            return ErrorCode.DELSCHEDULE_FAIL_NULL;}
        else{
            try{
                scheduleMapper.delete(new QueryWrapper<Schedule>().eq("id",dateId));
            }catch (Exception e){
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.DELSCHEDULE_FAIL_DELETE;//删除错误
            }
        }
        return ErrorCode.DELSCHEDULE_SUCCESS;
    }

    @Override
    public Schedule getScheduleById(Integer dateId){
        Schedule schedule=null;
        try{
            schedule = scheduleMapper.selectOne(new QueryWrapper<Schedule>().eq("id",dateId));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return schedule;
        }


        return schedule;
    }


    @Override
    public ErrorCode updateSchedule(Integer dateId,Schedule schedule){
        if(scheduleMapper.selectOne(new QueryWrapper<Schedule>().eq("id",dateId))!=null) {
            try {
                scheduleMapper.update(schedule, new QueryWrapper<Schedule>().eq("id", dateId));
            } catch (Exception e) {
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.MODIFY_FAIL_UPDATE;//更新错误
            }
        }
        else{
            return ErrorCode.MODIFY_FAIL_NULL;
                }
        return ErrorCode.MODIFY_SUCCESS;
    }




    @Override
    public ErrorCode addScheduleItem(ScheduleItem schedule) {
        try {
            scheduleItemMapper.insert(schedule);
        }catch (Exception e){
            return ErrorCode.ADDSCHEDULE_FAIL_INSER;
        }
        return ErrorCode.ADDSCHEDULE_SUCCESS;
    }

    @Override
    public List<ScheduleItem> getScheduleByUserIdAndDate(Integer uid,String date) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        queryWrapper.eq("date",date);
        List<ScheduleItem> scheduleItemList = scheduleItemMapper.selectList(queryWrapper);
        return  scheduleItemList;
    }

    @Override
    public List<ScheduleItem> getMonthScheduleByUserIdAndDate(Integer uid, String date) {

        String startTime = date+"-"+"00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(startTime,new ParsePosition(0));
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        String endTime = sdf.format(dt1);



        List<ScheduleItem> scheduleItemList = scheduleItemMapper.selectList(new QueryWrapper<ScheduleItem>().between("date",startTime,endTime));

        return scheduleItemList;
    }

    @Override
    public ErrorCode updateScheduleItem(Integer dateId, ScheduleItem schedule) {
        if(scheduleItemMapper.selectOne(new QueryWrapper<ScheduleItem>().eq("id",dateId))!=null) {
            try {
                scheduleItemMapper.update(schedule, new QueryWrapper<ScheduleItem>().eq("id", dateId));
            } catch (Exception e) {
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.MODIFY_FAIL_UPDATE;//更新错误
            }
        }
        else{
            return ErrorCode.MODIFY_FAIL_NULL;
        }
        return ErrorCode.MODIFY_SUCCESS;
    }

    @Override
    public ScheduleItem getScheduleItemById(Integer dateId) {
        ScheduleItem scheduleItem=null;
        try{
            scheduleItem = scheduleItemMapper.selectOne(new QueryWrapper<ScheduleItem>().eq("id",dateId));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return scheduleItem;
        }


        return scheduleItem;
    }

    @Override
    public ErrorCode deleteScheduleItemById(Integer dateId) {
        if(scheduleItemMapper.selectOne(new QueryWrapper<ScheduleItem>().eq("id",dateId))==null){
            return ErrorCode.DELSCHEDULE_FAIL_NULL;}
        else{
            try{
                scheduleItemMapper.delete(new QueryWrapper<ScheduleItem>().eq("id",dateId));
            }catch (Exception e){
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.DELSCHEDULE_FAIL_DELETE;//删除错误
            }
        }
        return ErrorCode.DELSCHEDULE_SUCCESS;
    }

}
