package com.cgb.utils;

import java.util.Date;

/**
 * @Author CGB
 * @Date 2022/3/27 22:37
 */
public class DateTrance {

    static public java.sql.Date uDateToSDate(Date date){
        return new java.sql.Date(date.getTime());
    }
}
