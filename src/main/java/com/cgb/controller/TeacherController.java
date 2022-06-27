package com.cgb.controller;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Teacher;
import com.cgb.service.AdminService;
import com.cgb.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;
    Map<String,Object> params;

    @GetMapping("/list")
    public Result getTeacher(@RequestParam Map<String, Object> map){
       // params=new HashMap<>();
        List<Teacher> list=teacherService.getTeachers(map);
        return Result.success(ResultCode.LOGIN_SUCCESS,list);
    }


    @PostMapping("/rz")
    public Result teacherRz(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        map.put("uid",JwtUtil.getUserId(authorization));
        System.out.println(map);
        int result=teacherService.addTeacher(map);
        if(result==1){
            map.put("rid",5);
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

        int result=teacherService.rzTeacher(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }


    @PostMapping("/delst")
    public Result delstudent(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        //map.put("uid",JwtUtil.getUserId(authorization));

        int result=teacherService.deleteTeacher(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }
}
