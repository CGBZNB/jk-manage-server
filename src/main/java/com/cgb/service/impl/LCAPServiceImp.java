package com.cgb.service.impl;

import com.cgb.dao.ExamMapper;
import com.cgb.dao.LCAPMapper;
import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.exercises.LCAP;
import com.cgb.service.ExamService;
import com.cgb.service.LCAPService;
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
public class LCAPServiceImp implements LCAPService {

    @Autowired
    private LCAPMapper lcapMapper;
    @Override
    public List<LCAP> getLCAP(Map<String, Object> paramer) {
        return lcapMapper.getLCAP(paramer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int setLCAP(Map<String, Object> paramer) {
        List<LCAP> examAP = lcapMapper.getLCAP(paramer);
        if(examAP.size()==1){
            if(examAP.get(0).getMaked()>0){
                paramer.put("maked",examAP.get(0).getMaked()-1);
                lcapMapper.setLCAP(paramer);
                lcapMapper.addlcmd(paramer);
                return 1;
            }
        }


        return 0;
    }

    @Override
    public int addLCAP(Map<String, Object> paramer) {
        return lcapMapper.addLCAP(paramer);
    }

    @Override
    public int addlcmd(Map<String, Object> paramer) {
        return lcapMapper.addlcmd(paramer);
    }
}
