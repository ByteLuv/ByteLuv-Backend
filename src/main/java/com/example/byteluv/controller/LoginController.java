package com.example.byteluv.controller;

import com.example.byteluv.pojo.base.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
//        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
//            return "login";
//        }
//        //用户认证信息
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
//                user.getUserName(),
//                user.getPassword()
//        );
//        try {
//            //进行验证，这里可以捕获异常，然后返回对应信息
//            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
//        } catch (UnknownAccountException e) {
//            log.error("用户名不存在！", e);
//            return "用户名不存在！";
//        } catch (AuthenticationException e) {
//            log.error("账号或密码错误！", e);
//            return "账号或密码错误！";
//        } catch (AuthorizationException e) {
//            log.error("没有权限！", e);
//            return "没有权限";
//        }
//        return "login success";
        return "/login";
    }

    @PostMapping("/login")
    public String login(User user){
        return "sign up succestful";
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
