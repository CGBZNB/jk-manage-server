package com.cgb.controller;

import com.cgb.pojo.user.UserLogin;
import com.cgb.service.UserService;
import com.cgb.utils.DateTrance;
import com.cgb.utils.JsonResult;
import com.cgb.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/22 23:04
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
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
    public JsonResult registerUser(@PathVariable String code,UserLogin userLogin){
        if(!code.equals(mapCode.get(userLogin.getAccount()))){
            return new JsonResult(400,"验证码错误","400",false);
        }else {
            userLogin.setCreateTime(DateTrance.uDateToSDate(new Date()));
            int result=userService.addUser(userLogin);
            if(result==1){
                mapCode.remove(userLogin.getAccount());
                return new JsonResult(200,"添加用户成功",userLogin+code,true);
            }
            return new JsonResult(401,"失败","401",false);
        }
    }

}
