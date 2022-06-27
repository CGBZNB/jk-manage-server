package com.cgb.service.impl;

import com.cgb.dao.AdminMapper;
import com.cgb.dao.SchoolMapper;
import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.School;
import com.cgb.service.AdminService;
import com.cgb.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:52
 */
@Service
public class SchoolServiceImp implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getSchools(Map<String, Object> paramer) {
        return schoolMapper.getSchools(paramer);
    }

    @Override
    public int addSchool(Map<String, Object> paramer) {
        return schoolMapper.addSchool(paramer);
    }

    @Override
    public int rzSchool(Map<String, Object> paramer) {
        return schoolMapper.rzSchool(paramer);
    }

    @Override
    public int deleteSchool(Map<String, Object> paramer) {
        return schoolMapper.deleteSchool(paramer);
    }
}
