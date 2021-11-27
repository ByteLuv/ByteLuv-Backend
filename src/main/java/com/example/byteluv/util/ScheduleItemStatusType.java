package com.example.byteluv.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author MrWang98
 * @Date 2021/11/27 14:44
 **/
@Getter
@AllArgsConstructor
public enum ScheduleItemStatusType {
    Warning("warning"),
    Success("success"),
    Error("error"),
    Processing("processing"),
    Default("default");


    private String status;
}
