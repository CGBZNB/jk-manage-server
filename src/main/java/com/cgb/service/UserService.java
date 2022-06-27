package com.cgb.service;

import com.cgb.pojo.user.*;

import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/23 20:38
 */
public interface UserService {

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
