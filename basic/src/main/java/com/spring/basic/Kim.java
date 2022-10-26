package com.spring.basic;

import org.springframework.stereotype.Component;

@Component
public class Kim implements Human{
    @Override
    public void breath() {
        System.out.println("kim");
    }

    @Override
    public void walk() {

    }
}
