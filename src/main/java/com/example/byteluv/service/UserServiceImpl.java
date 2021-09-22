package com.example.byteluv.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.byteluv.mappers.UserMapper;
import com.example.byteluv.pojo.User;

import com.example.byteluv.util.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {

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

    @Override
    public ErrorCode addUser(User user) {
        if(userMapper.selectOne(new QueryWrapper<User>().eq("uname",user.getUname()))==null){
            try{
                userMapper.insert(user);
            }catch (Exception e){
                System.out.println("-------------");
                System.out.println(e.getMessage());
                System.out.println("-------------");
                return ErrorCode.SIGNUP_FAIL_INSERT;
            }
        }else{
            return ErrorCode.SIGNUP_FAIL_EXIST;
        }
        return ErrorCode.SIGNUP_SUCCESS;
    }

}