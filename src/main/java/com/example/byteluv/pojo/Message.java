package com.example.byteluv.pojo;

import com.example.byteluv.util.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @Date 2021/9/15 14:41
 * @User MrWang
 * @ClassName Message
 * @Descript
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private MessageType type;
    private Integer cardId;
    private String text;
    private Date sendTime;
    private Integer userId;
    private Boolean isRead;
}