package com.example.byteluv.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:29
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("schdule")
public class Schedule {
    private Integer id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String mainBody;
    private String type;
    private Integer uid;
}
