package com.cgb.service.impl;

import com.cgb.dao.SubjectMapper;
import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;
import com.cgb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author CGB
 * @Date 2022/3/30 21:48
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public int addSubject(SubjectItem subjectItem) {
        return subjectMapper.addSubject(subjectItem);
    }

    @Override
    public int addTitleChapter(TitleChapter titleChapter) {
        return subjectMapper.addTitleChapter(titleChapter);
    }

    @Override
    public int getTitleChapterCount(TitleChapter titleChapter) {
        return subjectMapper.getTitleChapterCount(titleChapter);
    }

    @Override
    public TitleChapter getTitleChapter(TitleChapter titleChapter) {
        return subjectMapper.getTitleChapter(titleChapter);
    }
}
