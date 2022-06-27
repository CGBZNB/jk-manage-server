package com.cgb.dao;

import com.cgb.pojo.Subject;
import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/30 21:46
 */
@Mapper
@Repository
public interface SubjectMapper {
    public int addSubject(SubjectItem subjectItem);
    public int addTitleChapter(TitleChapter titleChapter);
    public int getTitleChapterCount(TitleChapter titleChapter);
    public TitleChapter getTitleChapter(TitleChapter titleChapter);
    public List<TitleChapter> getTitleChapters(Map<String,Object>paramer);
    public List<SubjectItem> getSubjectItems(Map<String,Object>paramer);
    public List<SubjectItem> getExamItems(Map<String,Object>paramer);
    public int addScSubjct(Map<String,Object>paramer);
    public List<SubjectItem> getScSubjct(Map<String,Object>paramer);
    public int getScCount(Map<String,Object>paramer);


}
