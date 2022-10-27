package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")//공통 URL 진입점 설정
@Log4j2 //Log 라이브러리
public class BoardController {

    private final BoardService service;

//    게시물 목록 조회 요청 처리
    @GetMapping("/list")
//    void : board/list.jsp로 접속
//    String : 반환하는 주소
//    데이터를 담을 바구니의 종류
    /*
    * page - 1페이지를 넘어가면 사라짐(controller 하나의 페이지로 봄 jsp도 한 페이지로 봐서 요청이 안넘어감)
    * request - 1개 요청 하면 사라짐
    * session - 브라우저가 꺼지면 사라짐
    * application - 서버가 다운되면 사라짐
    * Model - Spring 에서 쓰는것 수명은 session과 같음*/
    public String list(Model model){

        List<Board> boardList = service.getList();

//        log에 변수 삽입
        log.info("/board/list GET 요청 발생 - {}" );


        /*로그 레벨의 종류
        * TRACE - 잡다한 자잘한 로그
        * DEBUG - 개발 단계의 디버깅
        * INFO  - 정보
        * WARN  - 경고
        * ERROR - 심각한 에러
        * */

        model.addAttribute("bList",boardList);
        return "board/list";
    }

}

