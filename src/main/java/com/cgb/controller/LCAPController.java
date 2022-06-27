package com.cgb.controller;

import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.exercises.LCAP;
import com.cgb.pojo.user.Student;
import com.cgb.pojo.user.Teacher;
import com.cgb.service.ExamService;
import com.cgb.service.LCAPService;
import com.cgb.service.StudentService;
import com.cgb.service.UserService;
import com.cgb.utils.JwtUtil;
import com.cgb.utils.Result;
import com.cgb.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 10:25
 */
@RestController
@RequestMapping("/lc")
public class LCAPController {

    @Autowired
    private LCAPService lcapService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @GetMapping("/addap")
    public Result addExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){
        Teacher teacher=userService.getTeacher(Integer.parseInt(JwtUtil.getUserId(authorization)));
        if(teacher!=null){
            map.put("tid",teacher.getId());
            int result=lcapService.addLCAP(map);
            if(result==1){
                return Result.success(ResultCode.LOGIN_SUCCESS,"添加成功");
            }else {
                return Result.failure(ResultCode.ERROR);
            }
        }

            return Result.failure(ResultCode.ERROR);

    }

    @GetMapping("/getap")
    public Result getExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){
        System.out.println(Integer.parseInt(JwtUtil.getUserId(authorization)));
        System.out.println(JwtUtil.getInfo(authorization));
        Teacher teacher=userService.getTeacher(Integer.parseInt(JwtUtil.getUserId(authorization)));
        if(teacher!=null){
            map.put("tid",teacher.getId());
            List<LCAP>list=lcapService.getLCAP(map);
            if(list.size()>0){
                System.out.println(list);
                return Result.success(ResultCode.LOGIN_SUCCESS,list);
            }else {
                return Result.failure(ResultCode.ERROR);
            }


        }

        return Result.failure(ResultCode.ERROR);

    }

    @GetMapping("/bm")
    public Result updateExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){

        map.put("uid",JwtUtil.getUserId(authorization));
        Student student=studentService.getStudentById(map);
        if(student!=null){
            map.put("sid",student.getId());
        }
        int result=lcapService.setLCAP(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"报名成功");
        }

        return Result.failure(ResultCode.ERROR);

    }

    @GetMapping("/qgetap")
    public Result qgetExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){
        System.out.println(Integer.parseInt(JwtUtil.getUserId(authorization)));
        System.out.println(JwtUtil.getInfo(authorization));
        map.put("uid",JwtUtil.getUserId(authorization));
        Student student=studentService.getStudentById(map);
        if(student!=null){
            map.put("tid",student.getTeacher().getId());
            List<LCAP>list=lcapService.getLCAP(map);
            if(list.size()>0){
                System.out.println(list);
                return Result.success(ResultCode.LOGIN_SUCCESS,list);
            }else {
                return Result.failure(ResultCode.ERROR);
            }


        }

        return Result.failure(ResultCode.ERROR);

    }


}
