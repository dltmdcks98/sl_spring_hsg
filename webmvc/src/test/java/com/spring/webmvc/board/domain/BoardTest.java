package com.spring.webmvc.board.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    @Test
    void builderTest(){

        Board board = new Board.Builder()
                .title("제목")
                .boardNo(20L)
                .content("hahha")
                .writer("가가가")//계속 return this를 하므로 계속 Builder의 메소드를 사용할 수 있다.
                .build();

    }
}