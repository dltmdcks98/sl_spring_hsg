package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")//공통 URL 진입점 설정
@Log4j2 //Log 라이브러리
public class BoardController {

    private final BoardService service;

//    게시물 목록 조회 요청 처리
    @GetMapping("/list")
    public void list(){
        int a=10;
//        log에 변수 삽입
        log.info("/board/list GET 요청 발생 - {}" ,a);

        /*로그 레벨의 종류
        * TRACE - 잡다한 자잘한 로그
        * DEBUG - 개발 단계의 디버깅
        * INFO  - 정보
        * WARN  - 경고
        * ERROR - 심각한 에러
        * */
    }

}

