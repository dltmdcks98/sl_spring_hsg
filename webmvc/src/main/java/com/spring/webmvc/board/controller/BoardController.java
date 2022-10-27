package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")//공통 URL 진입점 설정
public class BoardController {

    private final BoardService service;

//    게시물 목록 조회 요청 처리
    @GetMapping("/list")
    public void list(){
        System.out.println("/board/list GET 요청 발생");

    }

}

