package com.cgb.service;

import com.cgb.pojo.exercises.ExamAP;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 10:09
 */
public interface ExamService {
    public List<ExamAP> getExamAP(Map<String, Object> paramer);
    public int setExamAP(Map<String, Object> paramer);
    public int addExamAP(Map<String, Object> paramer);
    public ExamAP getExamAPById(Map<String, Object> paramer);
    public int addexmd(Map<String, Object> paramer);
}
