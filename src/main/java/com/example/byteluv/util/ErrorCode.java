package com.example.byteluv.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author MrWang98
 * @Date 2021/9/17 14:13
 **/
@Getter
@AllArgsConstructor
public enum ErrorCode {

    LOGIN_SUCCESS(0,0,"登录成功"),
    LOGIN_FAIL(1,1,"用户名或密码错误"),
    SIGNUP_FAIL_EXIST(2,1,"用户已存在"),
    SIGNUP_FAIL_INSERT(3,2,"注册失败"),
    SIGNUP_SUCCESS(4,0,"注册成功"),
    ADDSCHEDULE_FAIL_INSER(5,1,"添加日程失败"),
    ADDSCHEDULE_FAIL_DATAWRONG(6,1,"日期前后反向"),
    ADDSCHEDULE_SUCCESS(7,0,"添加日程成功");


    private Integer code;
    private Integer statusNum;
    private String descript;
}
