package com.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class School{

    private Human student;

    @Autowired
    public School(@Qualifier("kim")Human student) {
        this.student = student;
    }

    public void study() {
        System.out.println("학교에서 숨쉬기중~~");
        student.breath();
    }
}
