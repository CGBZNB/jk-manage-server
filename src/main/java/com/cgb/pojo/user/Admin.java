package com.cgb.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 *管理员:管理员名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int id;
    private String name;
    private String imgUrl;
    private String phone;
    private UserLogin userLogin;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
