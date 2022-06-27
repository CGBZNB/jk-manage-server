package com.cgb.pojo;

/**
 * @Author CGB
 * @Date 2022/3/17 21:56
 */
public enum Subject implements BaseEnum{
    SubjectOne(1,"科目一"),
    SubjectTwo(2,"科目二"),
    SubjectThree(3,"科目三"),
    SubjectFour(4,"科目四");

    private int id;
    private String name;

    private Subject(int id,String name){
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
