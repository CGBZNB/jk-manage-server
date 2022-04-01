package com.cgb.pojo.user;

import com.cgb.pojo.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import java.util.List;
/**
 * @Author CGB
 * @Date 2022/3/17 20:47
 *教练:教练姓名、电话 价格、介绍、所属、所拥有学员、所拥有车辆
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private String phone;
    private String price;
    private String introduce;
    private String imgStr;
    private int age;
    private Sex sex;
    private String idCard;
    private UserLogin userLogin;
    private School school;
    private List<Student> students;
    private List<Car> cars;
    private Date createTime;
    private Date updateTime;
    private int deleted;

}
