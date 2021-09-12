package com.example.byteluv.pojo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

/**
 * @Author MrWang
 * @Date 2020/10/9 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String telephoneNumber;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
