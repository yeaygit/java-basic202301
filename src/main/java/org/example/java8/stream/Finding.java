package org.example.java8.stream;


import static org.example.java8.stream.Dish.*;

public class Finding {
    public static void main(String[] args) {
        // anymatch: 주어진 스트림에서 적어도 한 요소와 일치하는게 있는지 확인
        // 요리목록중에 채식주의자가 먹을 수 있는 요리가 하나라도 있는가?

        boolean flag1 = menu.stream()
                .anyMatch(Dish::isVegetarian);

        System.out.println("flag1 = " + flag1);
        
        //요리중에 100칼로리보다 적은요리가 있는지
        boolean flag2 = menu.stream()
                .anyMatch(dish -> dish.getCalories() < 100);
        System.out.println("flag2 = " + flag2);
        
        
        //allMatch: 모든 요소가 조건에 일치하는지 확인 <-> nonMatch
        //요리 목록의 모든 요리가 1000칼로리 미만인가??
        boolean flag3 = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);



    }
}
