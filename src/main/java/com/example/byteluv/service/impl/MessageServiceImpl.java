package com.example.byteluv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.byteluv.mappers.MessageMapper;
import com.example.byteluv.pojo.Message;
import com.example.byteluv.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/10/12 17:11
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> getMessageByUid(Integer uid) {
        List<Message> messages = messageMapper.selectList(new QueryWrapper<Message>().eq("uid",uid));
        return messages;
    }

    @Override
    public Boolean sendMessage(Integer uid, Message message) {
        try{
            messageMapper.insert(message);
        }catch (Exception e){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteMessageById(Integer uid, Integer messageId) {
        Message message = messageMapper.selectOne(new QueryWrapper<Message>().eq("id",messageId));
        if(message.getUid()!=uid){
            return Boolean.FALSE;
        }else {
            messageMapper.deleteById(messageId);
            return Boolean.TRUE;
        }
    }
}
