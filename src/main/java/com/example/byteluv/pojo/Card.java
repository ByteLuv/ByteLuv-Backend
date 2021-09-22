package com.example.byteluv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Date 2021/9/15 14:42
 * @User MrWang
 * @ClassName Card
 * @Descript
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
}