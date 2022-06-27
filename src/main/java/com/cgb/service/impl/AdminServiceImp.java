package com.cgb.service.impl;

import com.cgb.dao.AdminMapper;
import com.cgb.dao.SubjectMapper;
import com.cgb.pojo.user.Admin;
import com.cgb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:52
 */
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> getAdmis(Map<String, Object> paramer) {
        return adminMapper.getAdmis(paramer);
    }
}
