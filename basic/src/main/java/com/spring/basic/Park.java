package com.spring.basic;

import org.springframework.stereotype.Component;

@Component
public class Park implements Human{
    @Override
    public void breath() {
        System.out.println("Park");
    }

    @Override
    public void walk() {

    }
}
