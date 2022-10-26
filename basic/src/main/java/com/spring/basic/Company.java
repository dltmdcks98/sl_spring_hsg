package com.spring.basic;

//회사는 반드시 직원(사람)이 필요하다
//회사는 사람에게 의존한다.
//회사는 사람을 컴포지션(속성) 해야한다.

import org.springframework.stereotype.Component;

//객체는 구현체(구체적인 사람)에 의존하면 안되고 역할에 의존
@Component
public class Company {

    private Human employee;

//    의존성 주입(외부에서 의존을 받겠다.)
    public Company(Human employee) {
        this.employee = employee;
    }

    public void work(){
        System.out.println("회사에서 숨쉬기");
        employee.breath();
    }
}
