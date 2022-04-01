package com.cgb.pojo.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * @Author CGB
 * @Date 2022/3/17 21:02
 * 车辆: 车牌号、品牌、使用年限、上次维修时间、驾校、教练
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String carNumber;
    private String brand;
    private String imgStr;
    private int age;
    private School school;
    private Teacher teacher;
    private Date lastRepairTime;
    private Date createTime;
    private Date updateTime;
    private int deleted;
}
