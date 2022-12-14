package com.spring.webmvc.board.controller;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
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

//    게시물 상세 조회 요청 처리
    @GetMapping("/content/{bno}")
//    @PathVariable 뒤의 변수명이 넘어오는 변수명과 같으면 설정할 것은 없지만, 변경하려면 @PathVariable("변수")로 받는다.
    public String content(@PathVariable("bno") Long boardNo, Model model){
        log.info("/board/content/{} - + GET",boardNo);

        model.addAttribute("b", service.getDetail(boardNo));
        return "board/detail";
    }

//    게시물 쓰기 화면 요청
    @GetMapping("/write")
    public String write(){
        log.info("/board/write GET");
        return "board/write";
    }
//    게시물 등록 요청
    @PostMapping("/write")
    public String write(Board board, RedirectAttributes ra){
        log.info("/board/write POST - {}", board);

        boolean flag = service.insert(board);
//        model에 담으면 redirect 하면 msg가 죽는다.
//        model.addAttribute("msg","insert-success");
        ra.addFlashAttribute("msg","insert-success");

        return flag ? "redirect:/board/list" : "redirect:/";
    }
}

