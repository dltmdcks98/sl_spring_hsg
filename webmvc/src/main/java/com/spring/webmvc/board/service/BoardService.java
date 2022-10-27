package com.spring.webmvc.board.service;

import com.spring.webmvc.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

// 역할 : 컨트롤러와 레파지토리 사이 중간 잡다한 처리를 담당
public class BoardService {

//    @Autowired => 필드주입 : 실행이나 문법상 문제가 없지만, 실행 중에 setter에 의해 값이 변경될 수 있다.
    private final BoardRepository repository;

//    이렇게 생성자에 Autowired를 생성자를 줘야 안정성이 확보된다.
    @Autowired
    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }
}
