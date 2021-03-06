package com.example.byteluv.pojo;

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
    private String type;
    private Integer cid;
    private String text;
    private Date sendTime;
    private Integer uid;
    private Boolean isRead;
}