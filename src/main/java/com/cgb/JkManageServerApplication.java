package com.cgb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cgb.dao")
public class JkManageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JkManageServerApplication.class, args);
    }

}
