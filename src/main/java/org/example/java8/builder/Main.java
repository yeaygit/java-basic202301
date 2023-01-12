package org.example.java8.builder;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Member.builder() //순서 상관없이
                .account("abc1234")
                .password("1234")
                .age(33)
                .regDate(LocalDateTime.now())
                .build();

        Board.builder()
                .id(1000L)
                .writer("김똘끼")
                .title("가나다라")
                .build();

    }
}
