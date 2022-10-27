package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//테스트시 스프링의 컨테이너를 사용할 것이라는 뜻
//=> 의존 객체를 스프링에게 주입받아 사용할 것이다.
@SpringBootTest

class BoardRepositoryTest {
//    Board interface에서 Ctrl+shift+t

//    junit5 부터는 모든 제한자를 디폴트제한으로 설정=>public이런거 쓰지말고 사용
//    필드 주입 사용
    @Autowired
    BoardRepository repository;

    @Test
    void bulkInsert(){
        for (int i = 1; i <= 300; i++) {
            Board b = new Board();
            b.setTitle("꿀꿀이" + i);
            b.setContent("알룡하세요~~~" + i);
            b.setWriter("대길이" + (300-i));


            repository.save(b);
        }
    }

}