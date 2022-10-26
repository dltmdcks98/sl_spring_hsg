package com.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class House {

    private Human father;

    @Autowired
    public House(@Qualifier("kim")Human father) {
        this.father = father;
    }

    public void sleep(){
        System.out.println("집에서 낮잠");
        father.breath();
    }
}
