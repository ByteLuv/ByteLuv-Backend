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
    ADDSCHEDULE_FAIL_EXIST(7,1,"日程已存在"),
    ADDSCHEDULE_SUCCESS(8,0,"添加日程成功"),
    DELSCHEDULE_FAIL_NULL(9,1,"所删日程为空"),
    DELSCHEDULE_FAIL_DELETE(10,1,"删除日程失败"),
    DELSCHEDULE_SUCCESS(11,0,"删除日程成功"),
    MODIFY_FAIL_NULL(12,1,"所改日程为空"),
    MODIFY_FAIL_UPDATE(13,1,"更新日程数据库失败"),
    MODIFY_SUCCESS(14,0,"修改成功");



    private Integer code;
    private Integer statusNum;
    private String descript;
}
