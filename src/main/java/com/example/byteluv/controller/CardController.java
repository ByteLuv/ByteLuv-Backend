package com.example.byteluv.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.byteluv.VO.CardDecorationVO;
import com.example.byteluv.VO.CardVO;
import com.example.byteluv.VO.LoginVO;
import com.example.byteluv.mappers.CardMapper;
import com.example.byteluv.pojo.Card;
import com.example.byteluv.pojo.CardDecoration;
import com.example.byteluv.service.CardService;
import com.example.byteluv.util.ErrorCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:27
 **/
@RestController
public class CardController {

    @Autowired
    CardMapper cardMapper;

    @Autowired
    CardService cardService;

    @ResponseBody
    @GetMapping("/userCardQuery")
    @ApiOperation(value = "userCardQuery")
    public String userCardQuery(@RequestParam Integer uid){


        Card card = null;
        card = cardService.getCardByUId(uid);

        Map<String,Object> result = new HashMap<>();
        if(card==null){
            result.put("ErrorCode",1);
        }else{
            result.put("ErrorCode",0);
            result.put("LoveLetterId",card.getId());
            result.put("CardTitle",card.getTitle());
            result.put("card",card);
        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;
    }

    @ResponseBody
    @GetMapping("/loveLetterQuery")
    public String loveLetterQuery(@RequestParam Integer cid){

        Card card = null;
        CardDecoration cardDecoration =null;
        card = cardService.getCardByCId(cid);
        cardDecoration =cardService.getCardDecByCId(cid);
        CardVO cardVO = new CardVO(card.getTitle(),card.getContent());
        CardDecorationVO cardDecorationVO =new CardDecorationVO(cardDecoration.getType(),
                cardDecoration.getXLocation(),
                cardDecoration.getYLocation(),
                cardDecoration.getXZoom(),
                cardDecoration.getYZoom(),
                cardDecoration.getRevolve());

        Map<String,Object> result = new HashMap<>();
        if(card==null){
            result.put("ErrorCode",1);
        }else{
            result.put("ErrorCode",0);
            result.put("Card",cardVO);
            result.put("CardDecoration",cardDecorationVO);



        }

        //将结果转为JSON
        String jsonString = JSON.toJSONString(result);
        JSONObject object = JSONObject.parseObject(jsonString);
        String json = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);

        return json;

    }
}

