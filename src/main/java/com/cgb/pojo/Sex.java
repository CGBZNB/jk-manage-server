package com.cgb.pojo;

import lombok.Data;

/**
 * @Author CGB
 * @Date 2022/3/17 21:30
 */
public enum Sex implements BaseEnum{

    Female(0,"女"),
    Male(1,"男");


    private final int id;
    private final String name;

    private Sex(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return this.name;
    }

}
