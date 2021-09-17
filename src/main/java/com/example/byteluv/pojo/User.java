package com.example.byteluv.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/*
 * @Date 2021/9/15 14:19
 * @User MrWang
 * @ClassName User
 * @Descript
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uname;

    private String password;

    private String email;

    private String phone;

    private Date birth;
}
