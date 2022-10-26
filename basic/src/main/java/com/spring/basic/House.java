package com.spring.basic;

import org.springframework.stereotype.Component;

@Component
public class House {

    private Human father;

    public House(Human father) {
        this.father = father;
    }

    public void sleep(){
        System.out.println("집에서 낮잠");
        father.breath();
    }
}
