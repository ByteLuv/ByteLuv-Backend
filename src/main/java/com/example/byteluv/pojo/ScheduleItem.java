package com.example.byteluv.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.byteluv.util.OwnType;
import com.example.byteluv.util.ScheduleItemStatusType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @Author MrWang98
 * @Date 2021/11/25 10:20
 **/
@Data
@Accessors(chain = true)
public class ScheduleItem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private ScheduleItemStatusType statusType;
    private String content;
    private Integer uid;
    private Date date;
    private OwnType ownType;
}
