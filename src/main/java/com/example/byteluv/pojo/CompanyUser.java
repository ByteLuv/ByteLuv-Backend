package com.example.byteluv.pojo;

import com.example.byteluv.pojo.base.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MrWang
 * @Date 2020/10/10 0:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUser extends User{
    private String IdCardFront;
    private String IdCardBack;
}
