package com.cgb.controller;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Student;
import com.cgb.service.AdminService;
import com.cgb.service.StudentService;
import com.cgb.service.UserService;
import com.cgb.utils.JwtUtil;
import com.cgb.utils.Result;
import com.cgb.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 10:23
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    Map<String,Object> params;

    @GetMapping("/list")
    public Result getStudents(@RequestParam Map<String, Object> map){
       // params=new HashMap<>();
        List<Student> list=studentService.getStudents(map);
        return Result.success(ResultCode.LOGIN_SUCCESS,list);
    }

    @PostMapping("/rz")
    public Result studentRz(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        map.put("uid",JwtUtil.getUserId(authorization));
        System.out.println(map);
        int result=studentService.addStudent(map);
        if(result==1){
            map.put("rid",4);
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

        int result=studentService.rzStudent(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }


    @PostMapping("/delst")
    public Result delstudent(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        //map.put("uid",JwtUtil.getUserId(authorization));

        int result=studentService.deleteStudent(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }
}

