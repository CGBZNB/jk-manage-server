package com.cgb.pojo;

/**
 * @Author CGB
 * @Date 2022/3/17 21:47
 */
public enum TopicType{
    SingleChoice(0,"单选题"),
    MultipleChoice(1,"多选题"),
    Judgement(3,"判断题");

    private int id;
    private String name;

    private TopicType(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
