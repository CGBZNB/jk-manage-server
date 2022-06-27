package com.cgb.service;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:51
 */
public interface StudentService {
    public List<Student> getStudents(Map<String, Object> paramer);
    public int addStudent(Map<String, Object> paramer);
    public int rzStudent(Map<String, Object> paramer);
    public int deleteStudent(Map<String, Object> paramer);
    public Student getStudentById(Map<String, Object> paramer);
}
