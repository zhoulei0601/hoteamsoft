package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Applicaiton
 */
@SpringBootApplication
@MapperScan("com.hoteamsoft.**.mapper")
public class HoteamsoftApplication {
    public static void main(String[] args) {
        SpringApplication.run(HoteamsoftApplication.class,args);
    }
}
