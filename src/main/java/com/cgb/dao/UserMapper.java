package com.cgb.dao;

import com.cgb.pojo.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/23 20:28
 */
@Mapper
@Repository
public interface UserMapper {

    public int addUser(UserLogin userLogin);
    public int isHaveUser(Map<String,Object> params);
    public UserLogin getUserLogin(Map<String,Object> params);
    public Student getStudet(int id);
    public Teacher getTeacher(int id);
    public School getSchool(int id);
    public Admin getAdmin(int id);
    public int updatePass(Map<String,Object> params);
    public int updateUser(Map<String,Object> params);

}
