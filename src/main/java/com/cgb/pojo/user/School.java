package com.cgb.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

import java.util.List;
/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 *驾校:驾校名称、电话 价格、介绍、地址、教练、学员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private int id;
    private String name;
    private UserLogin userLogin;
    private String phone;
    private double price;
    private String introduce;
    private String address;
    private String imgStr;
    private int age;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Car> cars;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
