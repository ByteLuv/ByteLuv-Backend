package com.example.byteluv.pojo;

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
@ApiModel(value="User对象", description="")
public class User {
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private String phone;
    private Date birth;
}
