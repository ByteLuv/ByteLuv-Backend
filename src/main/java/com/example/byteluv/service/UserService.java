package com.example.byteluv.service;

import com.example.byteluv.pojo.User;
import com.example.byteluv.util.ErrorCode;

/**
 * @Author MrWang
 * @Date 2020/10/11 0:14
 */
public interface UserService {
    public User getUserByName(String uname);
    public ErrorCode addUser(User user);
}
