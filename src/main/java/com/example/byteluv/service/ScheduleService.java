package com.example.byteluv.service;

import com.example.byteluv.pojo.Schedule;
import com.example.byteluv.pojo.ScheduleItem;
import com.example.byteluv.util.ErrorCode;

import java.util.Date;
import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:57
 **/
public interface ScheduleService {
    public List<Schedule> getScheduleByUidPeriod(Integer uid, String leftTime, String rightTime);
    public ErrorCode addSchedule(Schedule schedule);
    public ErrorCode deleteScheduleById(Integer dateId);
    public Schedule getScheduleById(Integer dateId);
    public ErrorCode updateSchedule(Integer dateId,Schedule schedule);

    public List<ScheduleItem> getScheduleByUserIdAndDate(Integer uid, String date);
    public ErrorCode addScheduleItem(ScheduleItem schedule);
    public ErrorCode updateScheduleItem(Integer dateId,ScheduleItem schedule);
    public ScheduleItem getScheduleItemById(Integer dateId);
    public ErrorCode deleteScheduleItemById(Integer dateId);
}
