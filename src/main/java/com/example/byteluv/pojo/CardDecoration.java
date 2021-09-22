package com.example.byteluv.pojo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author MrWang98
 * @Date 2021/9/22 14:16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDecoration {
    private Integer id;
    private String type;
    private Integer xLocation;
    private Integer yLocation;
    private Integer xZoom;
    private Integer yZoom;
    private Float revolve;
    private Integer cid;
}
