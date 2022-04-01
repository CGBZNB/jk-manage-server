package com.cgb.pojo;

import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.user.UserLogin;

import java.sql.Date;


/**
 * @Author CGB
 * @Date 2022/3/17 22:07
 * 评论
 */
public class Comment {

    private int id;
    private String content;
    private UserLogin userLogin;
    private SubjectItem subjectItem;
    private Date commentTime;
    private int likeCount;
}
