package com.example.byteluv.service;

import com.example.byteluv.pojo.Message;

import java.util.List;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:57
 **/
public interface MessageService {
    public List<Message> getMessageByUid(Integer uid);
    public Boolean sendMessage(Integer uid, Message message);
    public Boolean deleteMessageById(Integer uid,Integer messageId);
}
