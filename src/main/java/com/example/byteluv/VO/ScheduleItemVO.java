package com.example.byteluv.VO;

import com.example.byteluv.util.OwnType;
import com.example.byteluv.util.ScheduleItemStatusType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @Author MrWang98
 * @Date 2021/11/27 15:11
 **/
@Data
@Accessors(chain = true)
public class ScheduleItemVO {
    private ScheduleItemStatusType statusType;
    private String content;
    private Integer uid;
    private Date date;
    private OwnType ownType;
}
