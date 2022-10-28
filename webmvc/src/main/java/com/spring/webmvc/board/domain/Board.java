package com.spring.webmvc.board.domain;

import lombok.*;

import java.util.Date;
import java.util.Locale;

//DB 엔터이(테이블)과 1:1 매칭되는 Value Object
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Board {
    //   DB에서 값이 안넘어오는 값은 "0"이 아니라 null이어서 참조형 타입으로 설정
    private Long boardNo;
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private Date regDate;

//    커스텀 필드
    private String shortTitle;//줄임 제목

    private Board(Builder builder) {
        this.boardNo = builder.boardNo;
        this.writer = builder.writer;
        this.content = builder.content;
        this.title = builder.title;
        this.viewCnt = builder.viewCnt;
        this.regDate = builder.regDate;
    }

    //   Builder 패턴 구현
    public static class Builder {
        private Long boardNo;
        private String writer;
        private String content;
        private String title;
        private int viewCnt;
        private Date regDate;


        public Builder boardNo(Long boardNo) {
            this.boardNo = boardNo;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder viewCnt(int viewCnt) {
            this.viewCnt = viewCnt;
            return this;
        }

        public Builder regDate(Date regDate) {
            this.regDate = regDate;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}


