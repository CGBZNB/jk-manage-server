package com.cgb.pojo.exercises;

import com.cgb.pojo.user.Student;
import com.cgb.pojo.user.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author CGB
 * @Date 2022/4/16 10:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamAP {
    private int id;
    private String examtime;
    private String address;
    private int number;
    private int type;
    private int uid;
    private int maked;
    private List<Student> students;
}
