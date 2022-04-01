package com.cgb.dao;

import com.cgb.pojo.user.UserLogin;
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

}
