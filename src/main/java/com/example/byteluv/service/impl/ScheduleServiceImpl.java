package com.example.byteluv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.byteluv.mappers.ScheduleMapper;
import com.example.byteluv.pojo.Schedule;
import com.example.byteluv.pojo.User;
import com.example.byteluv.service.ScheduleService;
import com.example.byteluv.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(schedule.getStartTime().isBefore(schedule.getEndTime())){
            try{
                scheduleMapper.insert(schedule);
            }catch (Exception e){
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.ADDSCHEDULE_FAIL_INSER;
            }
        }else{
            return ErrorCode.ADDSCHEDULE_FAIL_DATAWRONG;
        }
        return ErrorCode.ADDSCHEDULE_SUCCESS;
    }

}
