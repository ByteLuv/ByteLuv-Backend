package com.example.byteluv.service;

import com.example.byteluv.pojo.base.Permissions;
import com.example.byteluv.pojo.base.Role;
import com.example.byteluv.pojo.User;
import com.sun.javaws.security.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserByName(String uname) {
        User user=null;
        return user;
    }

}