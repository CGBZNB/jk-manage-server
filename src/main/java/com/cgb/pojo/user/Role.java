package com.cgb.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 * 管理员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;
    private String name;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
