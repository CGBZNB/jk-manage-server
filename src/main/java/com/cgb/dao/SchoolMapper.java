package com.cgb.dao;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.School;
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
public interface SchoolMapper {

    public List<School> getSchools(Map<String, Object> paramer);
    public int addSchool(Map<String, Object> paramer);
    public int rzSchool(Map<String, Object> paramer);
    public int deleteSchool(Map<String, Object> paramer);
}
