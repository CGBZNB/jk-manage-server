package com.cgb.service.impl;

import com.cgb.dao.AdminMapper;
import com.cgb.dao.TeacherMapper;
import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Teacher;
import com.cgb.service.AdminService;
import com.cgb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:52
 */
@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeachers(Map<String, Object> paramer) {
        return teacherMapper.getTeachers(paramer);
    }

    @Override
    public int addTeacher(Map<String, Object> paramer) {
        return teacherMapper.addTeacher(paramer);
    }

    @Override
    public int rzTeacher(Map<String, Object> paramer) {
        return teacherMapper.rzTeacher(paramer);
    }

    @Override
    public int deleteTeacher(Map<String, Object> paramer) {
        return teacherMapper.deleteTeacher(paramer);
    }
}
