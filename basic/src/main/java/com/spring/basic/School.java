package com.spring.basic;

import org.springframework.stereotype.Component;

@Component
public class School{

    private Human student;

    public School(Human student) {
        this.student = student;
    }

    public void study() {
        System.out.println("학교에서 숨쉬기중~~");
        student.breath();
    }
}
