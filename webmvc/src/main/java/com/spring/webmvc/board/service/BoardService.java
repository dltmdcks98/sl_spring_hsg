package com.spring.webmvc.board.service;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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


        processBoardList(boardList);

        return boardList;
    }

    private void processBoardList(List<Board> boardList) {
        for (Board b : boardList) {
            subStringTitle(b);
            convertDateFormat(b);
            isNewArticle(b);
        }
    }

    private void isNewArticle(Board b) {
        //            신규 게시물 new 마크 처리(10분 이내 작성된 게시물)
        long regDate = b.getRegDate().getTime();//게시물 작성 시간(밀리초로 받아옴)
        long nowDate = System.currentTimeMillis();//현재 시간(밀리초)

        long diff = nowDate - regDate;//작성 후 지난 시간(밀리초)
        long limit = 10 * 60 * 1000; //10분을 밀리초로 변환

        if(diff <= limit){
            b.setNewArticle(true);
        }
    }

    //            날짜 포맷팅 처리
    private void convertDateFormat(Board b) {
        Date regDate = b.getRegDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm");
        b.setPrettierDate(sdf.format(regDate));
    }

    //        게시물 제목 줄임 처리
//        글 제목이 6글자 이상이면 6글자까지만 보여주고 뒤에 ...처리
    private void subStringTitle(Board b) {
        String title = b.getTitle();
        if(title.length() > 6){
            String shortTitle = title.substring(0,6) +"...";
            b.setShortTitle(shortTitle);
        } else {
            b.setShortTitle(title);
        }
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
