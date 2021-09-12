package com.example.byteluv.pojo;

import com.example.byteluv.pojo.base.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MrWang
 * @Date 2020/10/10 0:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUser extends User{
    private String post;
    private String employeeCard;
}
