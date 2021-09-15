package com.example.byteluv.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * @Date 2021/9/15 15:13
 * @User MrWang
 * @ClassName MessageType
 * @Descript
 */
@Getter
@AllArgsConstructor
public enum MessageType {

    LETTER(0),
    TEXT(1);

    private final Integer value;
}
