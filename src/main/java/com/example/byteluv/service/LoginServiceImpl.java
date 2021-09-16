package com.example.byteluv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.byteluv.mappers.UserMapper;
import com.example.byteluv.pojo.User;
import com.sun.javaws.security.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.util.*;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User>  implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String uname) {
        User user=null;
        try{
            user = userMapper.selectOne(new QueryWrapper<User>().eq("uname",uname));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return user;
        }
        return user;
    }

}