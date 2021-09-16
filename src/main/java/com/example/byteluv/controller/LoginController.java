package com.example.byteluv.controller;

import com.example.byteluv.pojo.User;
import com.example.byteluv.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    @ApiOperation(value = "登录")
    public String login(@RequestParam String uname,@RequestParam String passward) {
        if (StringUtils.isEmpty(uname) || StringUtils.isEmpty(passward)) {
            return "login";
        }
        User user = null;
        try {
            user = loginService.getUserByName(uname);
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
            return "没有权限";
        }
        if(user==null){
            return "login false";
        }else {
            return "login success";
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
