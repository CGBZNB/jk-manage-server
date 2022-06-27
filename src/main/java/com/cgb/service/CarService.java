package com.cgb.service;

import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Car;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:51
 */
public interface CarService {
    public List<Car> getCars(Map<String, Object> paramer);
}
