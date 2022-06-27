package com.cgb.pojo.exercises;

import com.cgb.pojo.Comment;
import com.cgb.pojo.Subject;
import com.cgb.pojo.TopicType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import java.util.List;

/**
 * @Author CGB
 * @Date 2022/3/17 22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectItem {
    private int id;
    private String content;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String answer;
    private String explain;
    private TitleChapter titleChapter;
    private int difficultLevel;
    private TopicType topicType;
    private String imgStr;
    private int imaged;
    private int flag;
    private String myAnswer;
    private boolean liked;
    private List<Comment> comments;
    private Date createTime;
    private Date updateTime;
    private int deleted;



}

