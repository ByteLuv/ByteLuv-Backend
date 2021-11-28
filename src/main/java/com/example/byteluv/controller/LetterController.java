package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.byteluv.VO.LetterVO;
import com.example.byteluv.pojo.LoveLetter;
import com.example.byteluv.service.LetterService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author MrWang98
 * @Date 2021/11/25 10:17
 **/
@RestController
public class LetterController {

    @Autowired
    LetterService letterService;

    @GetMapping("/getLetterByUid")
    public String getLetter(Integer uid){

        //返回前端的结果
        Map<String,Object> result = new HashMap<>();
        List<LoveLetter> loveLetterList = letterService.getLoveLetterByUid(uid);

        if(loveLetterList==null){
            result.put("ErrorCode",1);
            result.put("Descript","无情书");
        }
        else {
            result.put("ErrorCode",0);
            result.put("Schedule",loveLetterList);
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @PostMapping("/addLetterByUid")
    public String addLetterByUid(@RequestBody LetterVO letterVO){
        LoveLetter loveLetter = new LoveLetter();
        loveLetter.setUid(letterVO.getUid())
                .setContent(letterVO.getContent());
        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(letterService.addLoveLetterByUid(1,loveLetter)){
            result.put("ErrorCode",0);
            result.put("Descript","插入成功");
        }
        else {
            result.put("ErrorCode",1);
            result.put("Schedule","插入失败");
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @PostMapping("/updateLetterById")
    public String updateLetterById(@RequestParam Integer id, @RequestBody LetterVO letterVO){
        LoveLetter loveLetter = new LoveLetter();
        loveLetter.setUid(letterVO.getUid())
                .setContent(letterVO.getContent())
                .setId(id);
        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(letterService.updateLoveLetterById(loveLetter)){
            result.put("ErrorCode",0);
            result.put("Descript","修改成功");
        }
        else {
            result.put("ErrorCode",1);
            result.put("Schedule","修改失败");
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @GetMapping("/deleteLetterById")
    public String deleteLetterById(@RequestParam Integer id){
        //返回前端的结果
        Map<String,Object> result = new HashMap<>();

        if(letterService.deleteLoveLetterById(id)){
            result.put("ErrorCode",0);
            result.put("Descript","删除成功");
        }
        else {
            result.put("ErrorCode",1);
            result.put("Schedule","删除失败");
        }
        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }
}
