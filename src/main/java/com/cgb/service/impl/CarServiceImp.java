package com.cgb.service.impl;

import com.cgb.dao.AdminMapper;
import com.cgb.dao.CarMapper;
import com.cgb.pojo.user.Admin;
import com.cgb.pojo.user.Car;
import com.cgb.service.AdminService;
import com.cgb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author CGB
 * @Date 2022/4/14 9:52
 */
@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getCars(Map<String, Object> paramer) {
        return carMapper.getCars(paramer);
    }
}
