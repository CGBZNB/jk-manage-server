package com.cgb.service;

import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/3/30 21:47
 */
public interface SubjectService {
    public int addSubject(SubjectItem subjectItem);
    public int addTitleChapter(TitleChapter titleChapter);
    public int getTitleChapterCount(TitleChapter titleChapter);
    public TitleChapter getTitleChapter(TitleChapter titleChapter);
    public List<SubjectItem> getSubjectItems(Map<String,Object> paramer);
    public List<TitleChapter> getTitleChapters(Map<String,Object>paramer);
    public List<SubjectItem> getExamItems(Map<String,Object>paramer);
    public int addScSubjct(Map<String,Object>paramer);
    public List<SubjectItem> getScSubjct(Map<String,Object>paramer);
    public int getScCount(Map<String,Object>paramer);

}
