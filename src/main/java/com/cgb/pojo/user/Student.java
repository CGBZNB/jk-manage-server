package com.cgb.pojo.user;

import com.cgb.pojo.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 *学员：姓名、年龄、性别、身份证号、手机号、照片、
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String phone;
    private Sex sex;
    private String imgUrl;
    private int age;
    private String idCard;
    private School school;
    private Teacher teacher;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
