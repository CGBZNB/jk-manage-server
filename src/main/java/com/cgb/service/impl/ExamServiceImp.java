package com.cgb.service.impl;

import com.cgb.dao.ExamMapper;
import com.cgb.pojo.exercises.ExamAP;
import com.cgb.service.ExamService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 10:09
 */
@Service
public class ExamServiceImp implements ExamService {

    @Autowired
    private ExamMapper examMapper;
    @Override
    public List<ExamAP> getExamAP(Map<String, Object> paramer) {
        return examMapper.getExamAP(paramer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int setExamAP(Map<String, Object> paramer) {

        List<ExamAP> examAP = examMapper.getExamAP(paramer);
        if(examAP.size()==1){
            if(examAP.get(0).getMaked()>0){
                paramer.put("maked",examAP.get(0).getMaked()-1);
                examMapper.setExamAP(paramer);
                examMapper.addexmd(paramer);
                return 1;
            }
        }


        return 0;
    }

    @Override
    public int addExamAP(Map<String, Object> paramer) {
        return examMapper.addExamAP(paramer);
    }

    @Override
    public ExamAP getExamAPById(Map<String, Object> paramer) {
        return null;
    }

    @Override
    public int addexmd(Map<String, Object> paramer) {
        return examMapper.addexmd(paramer);
    }
}
