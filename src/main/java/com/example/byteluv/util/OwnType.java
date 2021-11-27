package com.example.byteluv.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author MrWang98
 * @Date 2021/11/27 15:07
 **/
@Getter
@AllArgsConstructor
public enum OwnType {
    own(1),
    partner(2),
    together(3);

    private Integer ownType;
}
