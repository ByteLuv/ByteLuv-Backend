package com.example.byteluv.service;

import com.example.byteluv.pojo.User;

/**
 * @Author MrWang
 * @Date 2020/10/11 0:14
 */
public interface LoginService {
    public User getUserByName(String uname);
}
