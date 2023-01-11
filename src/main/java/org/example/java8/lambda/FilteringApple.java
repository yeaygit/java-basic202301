package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

import static org.example.java8.lambda.Color.RED;

public class FilteringApple {

    /**
     * @solution - try1 : 녹색사과를 필터링하는 메서드를 만들어야함
     * @problem
     * - 만약 다른 색깔 사과를 필터링해야되는 경우에는
     * - 새로운 메서드를 또 만들어야 한다.
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { //iter + enter
            if(apple.getColor()==Color.GREEN){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try2 : 색상을 파라미터화 한다
     * @problem
     * - 만약에 필터 기준이 색상이 아니라 무게였다면?
     * - 두번째 파라미터로 무게 기준을 받아내는 메서드를 또 만들어?
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { //iter + enter
            if(apple.getColor()==color){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution -  try 3 : 동작을 파라미터화 한다. - 추상적 조건으로 필터링
     * @problem
     * - 과일이 아니면...?
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) { //iter + enter
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    //람다는 인터페이스의 추상메소드가 꼭 하나여야만 사용이 가능하다.


    /**
     * @solution - try 4: 제네릭 필터 메서드 생성
     */
    public static <T> List<T> filter(List<T> inventory, GenericPredicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : inventory) { //iter + enter
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }


    /**
     * 리스트와 변경조건을 전달하면 리스트 내부의 값을 변경 조건에 따라
     * 변환한 뒤 반환하는 map  이라ㅡ는 메서드 구현
     * map(appleList,apple->apple.setColor(Red))
     */

    public static <T, R> List<R> map(List<T> list, GenericFunction<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r = mapper.apply(t);
            result.add(r);
        }
        return result;
    }

}
