package com.example.byteluv.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class CardDecorationVO {
    private String type;
    private Integer xLocation;
    private Integer yLocation;
    private Integer xZoom;
    private Integer yZoom;
    private Float revolve;
}
