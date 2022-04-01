package com.cgb.service;

import com.cgb.pojo.user.UserLogin;

import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/23 20:38
 */
public interface UserService {

    public int addUser(UserLogin userLogin);
    public int isHaveUser(Map<String,Object> params);
}
