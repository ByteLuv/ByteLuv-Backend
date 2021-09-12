package com.example.byteluv.pojo;

import com.example.byteluv.pojo.base.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @Author MrWang
 * @Date 2020/10/9 23:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String companyName;
    private Integer scale;
    private String businessRegistInfo;
    private String legalPerson;
    private String registCapital;
    private Integer industryClassification;
    private String addr;
    private String companyTele;
    private String businessLicense;
    /**
     * 公司的角色
     */
    private Set<Role> roles;
}
