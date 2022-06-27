package com.cgb.controller;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.School;
import com.cgb.pojo.user.Teacher;
import com.cgb.service.AdminService;
import com.cgb.service.SchoolService;
import com.cgb.service.UserService;
import com.cgb.utils.JwtUtil;
import com.cgb.utils.Result;
import com.cgb.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 10:23
 */
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private UserService userService;
    Map<String,Object> params;

    @GetMapping("/list")
    public Result getschools(@RequestParam Map<String, Object> map){
       // params=new HashMap<>();
        List<School> list=schoolService.getSchools(map);

        return Result.success(ResultCode.LOGIN_SUCCESS,list);
    }


    @PostMapping("/rz")
    public Result schoolRz(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        map.put("uid",JwtUtil.getUserId(authorization));
        System.out.println(map);
        int result=schoolService.addSchool(map);
        if(result==1){
            map.put("rid",6);
            result=  userService.updateUser(map);
            if(result==1){
                return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
            }
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }

    @PostMapping("/rzty")
    public Result studentRzTy(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        //map.put("uid",JwtUtil.getUserId(authorization));

        int result=schoolService.rzSchool(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }


    @PostMapping("/delst")
    public Result delstudent(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        //map.put("uid",JwtUtil.getUserId(authorization));

        int result=schoolService.deleteSchool(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }
}
