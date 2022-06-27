package com.cgb.controller;

import com.cgb.pojo.exercises.LCAP;
import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Car;
import com.cgb.pojo.user.Teacher;
import com.cgb.service.AdminService;
import com.cgb.service.CarService;
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
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    Map<String,Object> params;

    @GetMapping("/list")
    public Result returnCode(){
        params=new HashMap<>();
        List<Car> list=carService.getCars(params);
        return Result.success(ResultCode.LOGIN_SUCCESS,list);
    }


    @GetMapping("/getcars")
    public Result getcars(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        Teacher teacher=userService.getTeacher(Integer.parseInt(JwtUtil.getUserId(authorization)));
        if(teacher!=null){
            map.put("tid",teacher.getId());
            List<Car> list=carService.getCars(map);
            if(list.size()>0){

                return Result.success(ResultCode.LOGIN_SUCCESS,list);
            }else {
                return Result.failure(ResultCode.ERROR);
            }
        }


        return Result.success(ResultCode.LOGIN_SUCCESS,"11");
    }

}
