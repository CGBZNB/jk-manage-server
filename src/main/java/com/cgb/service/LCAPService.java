package com.cgb.service;

import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.exercises.LCAP;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 10:09
 */
public interface LCAPService {
    public List<LCAP> getLCAP(Map<String, Object> paramer);
    public int setLCAP(Map<String, Object> paramer);
    public int addLCAP(Map<String, Object> paramer);
    public int addlcmd(Map<String, Object> paramer);
}
