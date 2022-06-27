package com.cgb.controller;

import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.user.Student;
import com.cgb.service.ExamService;
import com.cgb.service.StudentService;
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
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/addap")
    public Result addExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){
        System.out.println(map);
        map.put("uid",JwtUtil.getUserId(authorization));
        int result=examService.addExamAP(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"添加成功");
        }

            return Result.failure(ResultCode.ERROR);

    }

    @GetMapping("/getap")
    public Result getExamAP(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){

        map.put("uid",JwtUtil.getUserId(authorization));
        List<ExamAP> list=examService.getExamAP(map);

        if(list.size()>0){
            return Result.success(ResultCode.LOGIN_SUCCESS,list);
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
        int result=examService.setExamAP(map);
        if(result==1){
            return Result.success(ResultCode.LOGIN_SUCCESS,"报名成功");
        }

        return Result.failure(ResultCode.ERROR);

    }


}
