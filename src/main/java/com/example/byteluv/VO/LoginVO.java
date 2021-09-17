package com.example.byteluv.VO;

import com.example.byteluv.util.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author MrWang98
 * @Date 2021/9/17 15:02
 **/
@Data
@AllArgsConstructor
public class LoginVO {
    private ErrorCode ErrorCode;
    private Integer ID;
}
