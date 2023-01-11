package org.example.java8.lambda;

import java.util.List;

import static org.example.java8.lambda.Color.*;
import static org.example.java8.lambda.FilteringApple.filter;
import static org.example.java8.lambda.FilteringApple.filterApples;

public class Main {

    // 무게가 100g 이하인 사과 필터조건 내부클래스
    public static class LightApplePredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight()<=80;
        }
    }

    public static void main(String[] args) {
        //사과바구니 생성
        List<Apple> appleList = List.of(
                new Apple(80,Color.GREEN),
                new Apple(155,Color.GREEN),
                new Apple(120, RED),
                new Apple(97, RED),
                new Apple(200,Color.GREEN),
                new Apple(50, RED),
                new Apple(57,Color.YELLOW),
                new Apple(89,Color.YELLOW)

        );
        List<Apple> greenApples=FilteringApple.filterGreenApples(appleList);
        System.out.println("====== 녹색사과 필터링 ++++++");
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println("===== 원하는 색 사과 필터링 =====");
        List<Apple> wantedColorApples = FilteringApple.filterApplesByColor(appleList,GREEN);
        for (Apple wantedColorApple : wantedColorApples) {
            System.out.println(wantedColorApple);
        }


        System.out.println("===== 원하는 조건으로 필터링 =====");
        // 노랑사과만 필터링
        System.out.println("= 노란 사과 =");
        List<Apple> yellowApples = filterApples(appleList,new YellowApplePredicate());
        for (Apple yellowApple : yellowApples) {
            System.out.println(yellowApple);
        }

        //무게가 100g 이하인 사과만 필터링(내부 클래스)
        System.out.println("= 가벼운 사과 =");
        List<Apple> lightApples = filterApples(appleList,new LightApplePredicate());
        for (Apple lightApple : lightApples) {
            System.out.println(lightApple);
        }


        //무게가 100g 보다 큰 사과만 필터링(익명 클래스)
        System.out.println("= 무거운 사과 =");
        List<Apple> heavyApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>80;
            }
        });

        for (Apple heavyApple : heavyApples) {
            System.out.println(heavyApple);
        }


        System.out.println("= 녹색 사과 =");
        //녹색사과만 필터링
        //람다 사용 전제 조건 : 인터페이스의 추상 메서드가 단 하나일 것!
        //람다가 오버라이딩 하는 메서드가 단 한 줄 일 경우 중괄호 생략가능
        //그 한줄이 리턴문이라면   return 키워드 생략가능
        //파라미터가 단 한개 라면 소괄호 생략가능
        //어차피 오버라이딩 할 게 하나기 때문에 return type 같은 것들 필요없음..
        List<Apple> greenAppleList = filterApples(appleList, apple-> apple.getColor()==GREEN);
        for (Apple apple : greenAppleList) {
            System.out.println(apple);
        }

        //빨간색 사과면서  100 g 이상인 사과만 필터링
        System.out.println("= 빨간색 사과면서 100g 이상인 사과 =");
        List<Apple> redWeightMore=filterApples(appleList,apple -> {return apple.getColor()==RED && apple.getWeight()>=80;});

        for (Apple apple : redWeightMore) {
            System.out.println(apple);
        }

        System.out.println("= 제네릭 필터 메서드 =");
        filter(appleList, a->a.getColor()==RED);// 빨간사과만 필터링

        // 짝수만 필터링
        List<Integer> numbers=List.of(1,2,3,4,5,6,7,8,9,10);
        // generic을 integer 형태로 선언
        List<Integer> evenNumbers=filter(numbers,n->n%2==0);
        System.out.println(evenNumbers);
    }
}
