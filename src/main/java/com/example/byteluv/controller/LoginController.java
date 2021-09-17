package com.example.byteluv.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.byteluv.pojo.User;
import com.example.byteluv.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.byteluv.util.ErrorCode;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public String login(@RequestParam String uname,@RequestParam String pwd) {
        if (StringUtils.isEmpty(uname) || StringUtils.isEmpty(pwd)) {
            return JSON.toJSONString(ErrorCode.LOGIN_NULL);
        }
        User user = null;
        user=loginService.getUserByName(uname);
        if(user==null||!user.getPassword().equals(pwd)){
            return "账户或密码错误";
        }else {
            return JSON.toJSONString(user);
        }


    }

    @ResponseBody
    @GetMapping("/")
    public String home(){return "/login";}

    @ResponseBody
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @ResponseBody
    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin() {
        return "admin success!";
    }

    @ResponseBody
    @RequiresPermissions("query")
    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

    @ResponseBody
    @RequiresPermissions("add")
    @GetMapping("/add")
    public String add() {
        return "add success!";
    }
}
