package com.cgb.dao;

import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

}
