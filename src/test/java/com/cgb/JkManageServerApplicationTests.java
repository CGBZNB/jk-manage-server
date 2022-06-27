package com.cgb;


import com.cgb.dao.*;
import com.cgb.pojo.Subject;
import com.cgb.pojo.user.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JkManageServerApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    SchoolMapper schoolMapper;
    @Test
    void contextLoads() throws SQLException {

        Map<String,Object> paramer=new HashMap<>();
        paramer.put("name","acc");
        //System.out.println(studentMapper.getStudents(paramer));
       //System.out.println(teacherMapper.getTeachers(paramer));
        //System.out.println(userMapper.getUser(paramer));


    }

}
