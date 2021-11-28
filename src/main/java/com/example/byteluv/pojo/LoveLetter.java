package com.example.byteluv.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author MrWang98
 * @Date 2021/11/28 0:03
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoveLetter {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer uid;
    private String content;
}
