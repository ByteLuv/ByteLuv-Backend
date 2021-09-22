package com.example.byteluv.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer id;
    private Date startTime;
    private Date endTime;
    private String mainBody;
    private String type;
    private Integer uid;
}
