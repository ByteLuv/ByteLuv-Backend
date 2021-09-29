package com.example.byteluv.service;

import com.example.byteluv.pojo.Schedule;

import java.util.Date;
import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:57
 **/
public interface ScheduleService {
    public List<Schedule> getScheduleByUidPeriod(Integer uid, String leftTime, String rightTime);
}
