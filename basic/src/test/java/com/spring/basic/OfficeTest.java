package com.spring.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeTest {

    @Test
    void test(){
        Office office = new Office();
        Company company = office.company();
        School school = office.school();
        House house = office.house();

        company.work();
        school.study();
        house.sleep();

    }

}