package com.cgb.dao;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:50
 */
@Mapper
@Repository
public interface TeacherMapper {

    public List<Teacher> getTeachers(Map<String, Object> paramer);
    public int addTeacher(Map<String, Object> paramer);
    public int rzTeacher(Map<String, Object> paramer);
    public int deleteTeacher(Map<String, Object> paramer);
}
