package com.spring.basic;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    @Test
    void springTest() {

        //설정파일 읽어들이기
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        Company company = context.getBean(Company.class);
        School school = context.getBean(School.class);
        House house = context.getBean(House.class);

        company.work();
        school.study();
        house.sleep();
    }

}