package com.cgb.dao;

import com.cgb.pojo.exercises.ExamAP;
import com.cgb.pojo.exercises.LCAP;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/16 13:01
 */
@Mapper
@Repository
public interface LCAPMapper {
    public List<LCAP> getLCAP(Map<String, Object> paramer);
    public int setLCAP(Map<String, Object> paramer);
    public int addLCAP(Map<String, Object> paramer);
    public int addlcmd(Map<String, Object> paramer);
}
