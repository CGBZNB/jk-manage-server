package com.cgb.service;

import com.cgb.pojo.user.Admin;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:51
 */
public interface AdminService {
    public List<Admin> getAdmis(Map<String,Object> paramer);
}
