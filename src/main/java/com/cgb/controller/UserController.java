package com.cgb.controller;

import com.cgb.dao.UserMapper;
import com.cgb.pojo.user.Student;
import com.cgb.pojo.user.UserLogin;
import com.cgb.service.StudentService;
import com.cgb.service.UserService;
import com.cgb.utils.*;
import com.sun.deploy.uitoolkit.ui.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Date;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author CGB
 * @Date 2022/3/22 23:04
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentService studentService;
    private Map<String,String> mapCode=new HashMap<>();
    Map<String,Object> params;
    @GetMapping("/register/sendcode/{account}")
    public JsonResult returnCode(@PathVariable String account){
        String code=RandomCode.randomCode();
        mapCode.put(account,code);
        return new JsonResult(200,"成功",code,true);
    }

    @GetMapping("/register/validate/{date}/{type}")
    public JsonResult validate(@PathVariable String date,
                               @PathVariable String type){
        params=new HashMap<>();
        params.put(type,date);
        System.out.println(params);
        int result=userService.isHaveUser(params);
        return new JsonResult(200,"成功",result,true);
    }



    @PostMapping("/register/registeruser/{code}")
    public Result registerUser(@PathVariable String code,UserLogin userLogin){
        if(!code.equals(mapCode.get(userLogin.getAccount()))){
            return   Result.failure(400,"验证码错误");
           // return new JsonResult(400,"验证码错误","400",false);
        }else {
            userLogin.setCreateTime(DateTrance.uDateToSDate(new Date()));
            int result=userService.addUser(userLogin);
            if(result==1){
                mapCode.remove(userLogin.getAccount());
               // return new JsonResult(200,"添加用户成功",userLogin+code,true);
                return Result.success();
            }
            return Result.failure(ResultCode.ERROR);
        }
    }



    //登录
    @PostMapping("/login")
    public Result login(@RequestParam String account,@RequestParam String password) {
        params=new HashMap<>();
        params.put("name",account);

        UserLogin userLogin=userMapper.getUserLogin(params);

       if(userLogin==null){
           return Result.failure(ResultCode.USER_LOGIN_ERROR);
       }
       if(!password.equals(userLogin.getPassword())){
           return Result.failure(ResultCode.USER_LOGIN_ERROR);
       }

                //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("loginname", userLogin.getName());
        info.put("roleid", userLogin.getRole().getId());
        info.put("rolename", userLogin.getRole().getName());
        if(userLogin.getRole().getId()==3){
            info.put("name",userService.getAdmin(userLogin.getId()).getName());
        }else if(userLogin.getRole().getId()==4){
            info.put("name",userService.getStudet(userLogin.getId()).getName());
        }else if(userLogin.getRole().getId()==5){
            info.put("name",userService.getTeacher(userLogin.getId()).getName());
        }else if(userLogin.getRole().getId()==6){
            info.put("name",userService.getSchool(userLogin.getId()).getName());
        }
//        Student student=userService.getStudet(userLogin.getId());
//        if(student!=null){
//            info.put("studentname",student.getName());
//        }


        //生成JWT字符串
       String token = JwtUtil.sign((userLogin.getId())+"",info);
        System.out.println(JwtUtil.getInfo(token));
       return Result.success(ResultCode.LOGIN_SUCCESS,token);
       // return Result.success();
    }


//    @PostMapping("/login")
//    public Result userLogin(@RequestParam String account,@RequestParam String password){
//        params=new HashMap<>();
//        params.put("name",account);
//        UserLogin userLogin=userService.getUserLogin(params);
//        System.out.println(userLogin);
//        return Result.success();
//    }
    @GetMapping("/userinfo")
    public Result userinfo(@RequestHeader(value = "Authorization") String authorization) {

        System.out.println(JwtUtil.getInfo(authorization));
        return Result.success(JwtUtil.getInfo(authorization));
    }

    @PostMapping("/modifypass")
    public Result modifypass(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map) {

        map.put("uid",JwtUtil.getUserId(authorization));

        int result=userService.updatePass(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"操作成功");
        }

        return Result.failure(ResultCode.ERROR,"操作失败");
    }









}
