package com.cgb.service;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:51
 */
public interface TeacherService {
    public List<Teacher> getTeachers(Map<String, Object> paramer);
    public int addTeacher(Map<String, Object> paramer);
    public int rzTeacher(Map<String, Object> paramer);
    public int deleteTeacher(Map<String, Object> paramer);
}
