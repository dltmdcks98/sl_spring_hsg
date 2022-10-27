package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
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

//    단언(Assertion) : 강하게 주장하다
//    테스트 이름은 단언하게 작성해야한다.
    @Test
    @DisplayName("300번 게시글을 조회했을 때 제목이 꿀꿀이 300이어야 한다.")
    void findOneTest(){
//        테스트 기법 given, when, then

//        given : 테스트시 주어지는 변동 데이터
        Long boardNo = 300L;
//        when : 테스트 실제 상황
        Board board = repository.findOne(boardNo);
//        then : 테스트 예상 결과 assertEquals("내 예상 결과",실제 값)
        assertEquals("꿀꿀이300",board.getTitle());
        assertTrue(board.getViewCnt()==0);
        assertNotEquals("대길이200",board.getWriter());
        assertNotNull(board);
    }

}