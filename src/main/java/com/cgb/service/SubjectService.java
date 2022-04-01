package com.cgb.service;

import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;

/**
 * @Author CGB
 * @Date 2022/3/30 21:47
 */
public interface SubjectService {
    public int addSubject(SubjectItem subjectItem);
    public int addTitleChapter(TitleChapter titleChapter);
    public int getTitleChapterCount(TitleChapter titleChapter);
    public TitleChapter getTitleChapter(TitleChapter titleChapter);

}
