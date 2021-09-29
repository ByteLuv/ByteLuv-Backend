package com.example.byteluv.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime endTime;

    private String mainBody;
    private String type;
    private Integer uid;
}
