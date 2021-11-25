package com.example.byteluv.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author MrWang98
 * @Date 2021/11/25 10:20
 **/
@Data
@Accessors(chain = true)
public class ScheduleContent {
    private Integer id;
    private String type;
    private String content;
    private Integer uid;
}
