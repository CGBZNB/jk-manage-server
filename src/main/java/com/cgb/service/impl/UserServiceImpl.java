package com.cgb.service.impl;

import com.cgb.dao.UserMapper;
import com.cgb.pojo.user.*;
import com.cgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/23 20:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserLogin userLogin) {
        System.out.println(userLogin);
        return userMapper.addUser(userLogin);
    }

    @Override
    public int isHaveUser(Map<String, Object> params) {
        return userMapper.isHaveUser(params);
    }

    @Override
    public UserLogin getUserLogin(Map<String, Object> params) {

    return userMapper.getUserLogin(params);
    }


    @Override
    public Student getStudet(int id) {
        return userMapper.getStudet(id);
    }

    @Override
    public Teacher getTeacher(int id) {
        return userMapper.getTeacher(id);
    }

    @Override
    public School getSchool(int id) {
        return userMapper.getSchool(id);
    }

    @Override
    public Admin getAdmin(int id) {
        return userMapper.getAdmin(id);
    }

    @Override
    public int updatePass(Map<String, Object> params) {
        return userMapper.updateUser(params);
    }

    @Override
    public int updateUser(Map<String, Object> params) {
        return userMapper.updateUser(params);
    }


}
