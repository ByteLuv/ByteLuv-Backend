package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.byteluv.pojo.User;
import com.example.byteluv.service.UserService;
import com.example.byteluv.util.ErrorCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {



    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/login")
    public String login(@RequestParam String uname,@RequestParam String pwd) {

        //从数据库里寻找用户信息
        User user = null;
        user = userService.getUserByName(uname);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        //无此用户或者用户密码错误
        if(user==null||!user.getPassword().equals(pwd)){
            result.put("ErrorCode",2);
            result.put("Descript","用户名或密码错误");
        }else {
            result.put("ErrorCode",0);
            result.put("uid",user.getId());
            result.put("Descript","登录成功");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
    }

    @ResponseBody
    @GetMapping("/")
    public String home(){return "/login";}


    @ResponseBody
    @PostMapping("/signup")
    public String signup(User user){

        //将用户添加到数据库
        ErrorCode addResult = userService.addUser(user);

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        //无此用户或者用户密码错误
        if(addResult==ErrorCode.SIGNUP_FAIL_INSERT){
            result.put("ErrorCode",1);
            result.put("Descript","注册失败，插入数据库失败");
        }else if(addResult==ErrorCode.SIGNUP_FAIL_EXIST){
            result.put("ErrorCode",1);
            result.put("Descript","注册失败，该用户已存在");
        }else {
            user = userService.getUserByName(user.getUname());
            result.put("ErrorCode",0);
            result.put("uid",user.getId());
            result.put("Descript","注册成功");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
    }

    @ResponseBody
    @GetMapping("/information")
    public String information(@RequestParam String uname,@RequestParam(required = false)String email,@RequestParam(required = false) String phone,@RequestParam Integer id){

        User user = null;
        user = userService.getUserByName(uname); //从数据库里寻找用户信息

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        //查无此用户
        if(user==null){
            result.put("ErrorCode",1);
            result.put("Descript","查看用户信息失败");
        }else {
            result.put("ErrorCode",0);
            result.put("Descript","查看用户信息成功");
            result.put("uid",user.getId());
            result.put("uname",user.getUname());
            result.put("telephone",user.getPhone());
            result.put("email",user.getEmail());
            result.put("birthday",user.getBirth());
//            result.put("MessageCode",);还需要函数遍历数据库查message

        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        //返回结果
        return json;
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
