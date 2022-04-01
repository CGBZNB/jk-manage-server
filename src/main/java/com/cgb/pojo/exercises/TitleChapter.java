package com.cgb.pojo.exercises;

import com.cgb.pojo.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


/**
 * @Author CGB
 * @Date 2022/3/17 21:54
 *
 * 题目章节
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleChapter {
    private int id;
    private String name;
    private int count;
    private Subject subject;
    private Date createTime;
    private Date updateTime;
    private int deleted;

    public TitleChapter(String name, Subject subject, Date createTime) {
        this.name = name;
        this.subject = subject;
        this.createTime = createTime;
    }
}
