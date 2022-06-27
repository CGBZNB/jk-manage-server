package com.cgb.dao;

import com.cgb.pojo.user.Admin;
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
public interface AdminMapper {

    public List<Admin> getAdmis(Map<String,Object> paramer);
}
