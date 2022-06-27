package com.cgb.pojo.exercises;

import com.cgb.pojo.user.Car;
import com.cgb.pojo.user.Student;
import com.cgb.pojo.user.Teacher;
import com.cgb.pojo.user.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author CGB
 * @Date 2022/4/16 12:43
 * 练车安排
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LCAP {
    private int id;
    private String starttime;
    private String endtime;
    private Car car;
    private Teacher teacher;
    private int number;
    private int type;
    private int maked;
    private List<Student> students;
}
