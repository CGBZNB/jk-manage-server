package com.cgb.pojo;

import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;


public interface BaseEnum {

    String DEFAULT_ID_NAME = "id";

    String DEFAULT_NAME_NAME = "name";

    default Integer getValue() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_ID_NAME);
        if (field == null)
            return null;
        try {
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    default String getLabel() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_NAME_NAME);
        if (field == null)
            return null;
        try {
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static <T extends Enum<T>> T valueOfEnum(Class<T> enumClass, Integer value) {
        if (value == null)
            throw  new IllegalArgumentException("DisplayedEnum value should not be null");
        if (enumClass.isAssignableFrom( com.cgb.pojo.BaseEnum.class))
            throw new IllegalArgumentException("illegal DisplayedEnum type");
        T[] enums = enumClass.getEnumConstants();
        for (T t: enums) {
            com.cgb.pojo.BaseEnum displayedEnum = ( com.cgb.pojo.BaseEnum)t;
            if (displayedEnum.getValue().equals(value))
                return (T) displayedEnum;
        }
        throw new IllegalArgumentException("cannot parse integer: " + value + " to " + enumClass.getName());
    }

    static <T> T valueOfEnum1(T[] enums, Integer value) {

        for (T t: enums) {
            com.cgb.pojo.BaseEnum displayedEnum = ( com.cgb.pojo.BaseEnum)t;
            if (displayedEnum.getValue().equals(value))
                return (T) displayedEnum;
        }
        throw new IllegalArgumentException("cannot parse integer: " + value + " to " );
    }
}
