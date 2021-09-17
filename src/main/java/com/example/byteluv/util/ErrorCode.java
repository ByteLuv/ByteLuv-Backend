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

    LOGIN_SUCCESS(0,"登录成功"),
    LOGIN_NULL(1,"用户名或密码为空"),
    LOGIN_FAIL(2,"用户名或密码错误");

    private Integer statusNum;
    private String descript;
}
