package org.example.java8.stream.practice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Comparator.*;

@Getter
@RequiredArgsConstructor

public class Transaction {
    private final Trader trader; // 거래자
    private final int year; // 거래연도
    private final int value; // 거래금액

    @Override
    public String toString() {
        return String.format("{%s, year: %d, value: %d}", trader, year, value);
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        //연습 1 : 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬
        List<Transaction> tranList;
        tranList = transactions.stream()
                .filter(transaction -> transaction.getYear()==2021)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        out.println("2021 transactions = " + tranList);

        //연습 2 : 거래자가 근무하는 모든 도시이름을 중복없이 나열하시오.
        List<String> cityList=transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        out.println("city list = " + cityList);



        //연습 3 : Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트 이름순으로 오름차정렬
        List<Trader> traderCambridge= transactions.stream()
                .map(Transaction::getTrader) //이거 먼저하기
                .filter(td -> td.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        out.println("trader in cambridge " + traderCambridge);


        //연습 4 : 모든 거래자의 이름을 리스트에 모아서 알파벳 순으로 오름차정렬하여 반환
        List<String> traderAllList= transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted() //정렬리스트 대상이 String이나 숫자타입이면 Comparator을 안써도 정렬
                .collect(Collectors.toList());
        out.println("trader name " + traderAllList);
    }
}

