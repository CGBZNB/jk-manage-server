package com.cgb;


import com.cgb.dao.UserMapper;
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
    @Test
    void contextLoads() throws SQLException {

        Subject subject=Subject.SubjectOne;
        System.out.println(subject.getId());

    }

}
