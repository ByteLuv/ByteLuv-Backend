package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.byteluv.pojo.Message;
import com.example.byteluv.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:27
 **/
@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @ResponseBody
    @GetMapping("/mailBoxQuery")
    public String mailBoxQuery(@RequestParam Integer uid){
        List<Message> messages = messageService.getMessageByUid(uid);

        Map<String,Object> result = new HashMap<>();
        if(messages==null){
            result.put("ErrorCode",1);
            result.put("Descript","没有与此人有关的消息");
        }else {
            result.put("ErrorCode",0);
            result.put("messages",messages);
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @ResponseBody
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam Integer uid,Message message){

        Map<String,Object> result = new HashMap<>();

        if(message==null||message.getUid()==null){
            result.put("ErrorCode",1);
            result.put("Descript","发送人id不能为空");
        }
        if(messageService.sendMessage(uid,message)){
            result.put("ErrorCode",0);
            result.put("Descript","发送成功");
        }else {
            result.put("ErrorCode",1);
            result.put("Descript","发送失败");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @ResponseBody
    @GetMapping("/deleteMessage")
    public String deleteMMessageById(@RequestParam Integer uid,@RequestParam Integer messageId){
        Map<String,Object> result = new HashMap<>();
        if(messageService.deleteMessageById(uid,messageId)){
            result.put("ErrorCode",0);
            result.put("Descript","删除成功");
        }else {
            result.put("ErrorCode",1);
            result.put("descript","用户无此id的信息，删除失败");
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

}
