package com.cgb.service.impl;

import com.cgb.dao.AdminMapper;
import com.cgb.dao.StudentMapper;
import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Student;
import com.cgb.service.AdminService;
import com.cgb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:52
 */
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents(Map<String, Object> paramer) {
        return studentMapper.getStudents(paramer);
    }

    @Override
    public int addStudent(Map<String, Object> paramer) {
        return studentMapper.addStudent(paramer);
    }

    @Override
    public int rzStudent(Map<String, Object> paramer) {
        return studentMapper.rzStudent(paramer);
    }

    @Override
    public int deleteStudent(Map<String, Object> paramer) {
       return studentMapper.deleteStudent(paramer);
    }

    @Override
    public Student getStudentById(Map<String, Object> paramer) {
        return studentMapper.getStudentById(paramer);
    }
}
