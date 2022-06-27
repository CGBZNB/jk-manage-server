package com.cgb.controller;

import com.cgb.pojo.user.Admin;
import com.cgb.service.AdminService;
import com.cgb.utils.JsonResult;
import com.cgb.utils.RandomCode;
import com.cgb.utils.Result;
import com.cgb.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 10:23
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    Map<String,Object> params;

    @GetMapping("/list")
    public Result returnCode(){
        params=new HashMap<>();
        List<Admin> admins=adminService.getAdmis(params);
        return Result.success(ResultCode.LOGIN_SUCCESS,admins);
    }
}
