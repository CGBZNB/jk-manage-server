package com.cgb.controller;

import com.cgb.pojo.Subject;
import com.cgb.pojo.TopicType;
import com.cgb.pojo.exercises.SubjectItem;
import com.cgb.pojo.exercises.TitleChapter;
import com.cgb.service.SubjectService;
import com.cgb.utils.DateTrance;
import com.cgb.utils.HtmlParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.Random;

/**
 * 爬虫工具，提供去互联网爬取题库的方法
 */
@Controller
public class SpiderController {

    public static  String baseimgUrl = "https://www.jiazhao.com/";
    @Autowired
    private SubjectService subjectService;
    private TitleChapter titleChapter;

    /**
     * 这个是爬虫类，用来从互联网上爬取题目，省去了每次一个个添加的麻烦。
     */
    @RequestMapping(value ="/spider",method = {RequestMethod.GET})
    @ResponseBody
    public  void spilder(){
        //爬虫怕的数量不需要太多，够用就行
        for(int i=2323;i<2324;i++) {
            int type = 1;//题目类型
            SubjectItem subjectItem = new SubjectItem();
            String iamgeUrl;
            String s = null;
            try {
                s = HtmlParser.httpPostWithJSON("https://www.jiazhao.com/tiba/"+i+"/");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Document document = Jsoup.parse(s);
            Elements body = document.select("div[class=topic-l f-l]");
            Elements body2 = document.select("div[class=mbx]");
            //其中包含字母和答案
            Elements li = body.select("li");
            Elements a=body2.select("a");
            if(a.size()==3){
                titleChapter=new TitleChapter(a.get(2).html(),Subject.SubjectOne,DateTrance.uDateToSDate(new Date()));

            }
            if (li.size() == 6) {
                //选择题
                subjectItem.setContent(li.get(0).html());
                ;
                subjectItem.setChoiceA(li.get(1).html());
                subjectItem.setChoiceB(li.get(2).html());
                subjectItem.setChoiceC(li.get(3).html());
                subjectItem.setChoiceD(li.get(4).html());
                subjectItem.setAnswer(li.select("strong").html());
                subjectItem.setTopicType(TopicType.SingleChoice);
            } else {
                //判断题
                subjectItem.setContent(li.get(0).html());
                subjectItem.setChoiceA(li.get(1).html());
                subjectItem.setChoiceC(li.get(2).html());
                subjectItem.setAnswer(li.select("strong").html());
                subjectItem.setTopicType(TopicType.Judgement);
            }
            Elements image = document.select("div[class=topic-r f-l imgorvideo]");

            if (image.size() > 0) {
                Elements img = image.get(0).select("img");
                if (img.size() > 0) {
                    subjectItem.setImgStr(baseimgUrl + img.attr("src"));
                    subjectItem.setImaged(1);
                }
            }
            Elements analyse = document.select("div[class=topic-b analy-note t-bg]");
            Elements p = analyse.select("p");
            String anastr = p.html();
            subjectItem.setExplain(anastr);
            Random random = new Random();
            subjectItem.setDifficultLevel(random.nextInt(3) + 1);
            System.out.println("爬取第"+i+"条数据："+subjectItem.toString());

            try {
                if(subjectService.getTitleChapterCount(titleChapter)<1){
                    subjectService.addTitleChapter(titleChapter);
                    subjectItem.setTitleChapter(titleChapter);
                }else {
                    subjectItem.setTitleChapter(subjectService.getTitleChapter(titleChapter));
                }

                subjectItem.setCreateTime(DateTrance.uDateToSDate(new Date()));
                subjectService.addSubject(subjectItem);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
