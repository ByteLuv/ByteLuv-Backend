package com.example.byteluv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @Date 2021/9/15 14:19
 * @User MrWang
 * @ClassName User
 * @Descript
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private String phone;
    private Date birth;
}
