package com.spring.basic;

public class Office {

    // 객체를 생성해서 주입한다.
    public Human human() {
        return new Park();
    }
    public School school() {
        return new School(human());
    }
    public House house() {
        return new House(human());
    }
    public Company company() {
        return new Company(human());
    }
}
