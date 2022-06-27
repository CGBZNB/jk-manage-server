package com.cgb.dao;

import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.user.School;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 10:05
 */
@Mapper
@Repository
public interface ExamMapper {
    public List<ExamAP> getExamAP(Map<String, Object> paramer);
    public ExamAP getExamAPById(Map<String, Object> paramer);
    public int setExamAP(Map<String, Object> paramer);
    public int addExamAP(Map<String, Object> paramer);
    public int addexmd(Map<String, Object> paramer);
}
