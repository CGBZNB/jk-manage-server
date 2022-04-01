package com.cgb.pojo.user;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 *用户登录：用户名、密码、角色、邮箱
 */
@Data
@NoArgsConstructor
public class UserLogin {
    private int id;
    private String name;
    private String account;
    private String password;
    private String email;
    private Role role;
    private Date createTime;
    private Date updateTime;
    private int deleted;

    public UserLogin(String name, String account, String password, Date createTime) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.createTime = createTime;
    }
}
