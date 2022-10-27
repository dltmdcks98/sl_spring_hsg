package com.spring.webmvc.board.service;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// 역할 : 컨트롤러와 레파지토리 사이 중간 잡다한 처리를 담당
@RequiredArgsConstructor //final필드 초기화 생성자를 만듦
@Service
public class BoardService {

//    @Autowired => 필드주입 : 실행이나 문법상 문제가 없지만, 실행 중에 setter에 의해 값이 변경될 수 있다.
    private final BoardRepository repository;
    /*
    private int arg;

    @AllArgsConstructor
    public BoardService(int arg, BoardRepository repository) {
        this.arg = arg;
        this.repository = repository;
    }*/

//    전체 조회 중간처리
    public List<Board> getList(){
        List<Board> boardList = repository.findAll();
        return boardList;
    }
//    상세 조회 중간처리
    public Board getDetail(Long boardNo){
        Board board = repository.findOne(boardNo);
        return board;
    }
//    게시물 저장 중간처리
    public boolean insert(Board board){
        boolean flag = repository.save(board);
        return flag;
    }
//    게시물 수정 중간처리
    public boolean update(Board board){
        boolean flag = repository.modify(board);
        return flag;
    }
//    게시물 삭제 중간처리
    public boolean delete(Long boardNo){
        boolean flag = repository.remove(boardNo);
        return flag;
    }

}
