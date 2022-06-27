package com.cgb.controller;

import com.cgb.dao.SubjectMapper;
import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;
import com.cgb.service.SubjectService;
import com.cgb.utils.JsonResult;
import com.cgb.utils.JwtUtil;
import com.cgb.utils.Result;
import com.cgb.utils.ResultCode;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/3 23:53
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getchaptes")
    public JsonResult getchaptes(){
        List<TitleChapter> titleChapters = subjectService.getTitleChapters(null);
        return new JsonResult(200,"成功",titleChapters,true);
    }
    @GetMapping("/getsubjects")
    public JsonResult getsubjects(@RequestParam Map<String, Object> map){
        List<SubjectItem> subjectItems = subjectService.getSubjectItems(map);
        return new JsonResult(200,"成功",subjectItems,true);
    }
    @GetMapping("/getexam")
    public JsonResult getExam(@RequestParam Map<String, Object> map){
        Map<String,Object> m=new HashMap<>();
        m.put("type",3);
        List<SubjectItem> list = subjectService.getExamItems(m);
        map.clear();
        m.put("type",0);
        list.addAll(subjectService.getExamItems(m));
        return new JsonResult(200,"成功",list,true);
    }

    @GetMapping("/getsc")
    public Result getSc(@RequestHeader(value = "Authorization") String authorization,@RequestParam Map<String, Object> map){
        map.put("uid",JwtUtil.getUserId(authorization));
        List<SubjectItem> list = subjectService.getScSubjct(map);
        return Result.success(ResultCode.LOGIN_SUCCESS,list);
    }

    @GetMapping("/setsc")
    public Result setSc(@RequestHeader(value = "Authorization") String authorization, @RequestParam Map<String, Object> map){
        map.put("uid",JwtUtil.getUserId(authorization));
        if(subjectService.getScCount(map)==0){
           int result= subjectService.addScSubjct(map);
           if(result==1){
               Result.success(ResultCode.LOGIN_SUCCESS,"添加成功");
           }else {
               return Result.failure(ResultCode.ERROR,"添加失败");
           }

        }
        else {
            return Result.failure(ResultCode.ERROR,"已存在");
        }
        return Result.failure(ResultCode.ERROR);

    }

}
