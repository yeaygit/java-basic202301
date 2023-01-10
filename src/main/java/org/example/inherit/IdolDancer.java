package org.example.inherit;

import org.example.basic.Dancer;

public class IdolDancer extends Dancer {

    private int numberOfFan;//팬의 수

    //만약 생성자를 선언하지않으면 기본 생성자가 자동으로 만들어짐
    //pubic Idoldancer(){}

    public IdolDancer(String crewName,String myName){
        super(crewName,myName);
        this.numberOfFan=10;
        System.out.println("아이돌 댄서 생성됨");
    }
    //기본생성자를 제외한 다른 생성자를 만들면 main 에서 다른 생성자만 사용 가능


    //오버라이딩: 부모의 메서드를 재정의
    //부모의 메서드 시그니처(이름,리턴타입,파라미터)를 똑같이 맞춰야함

    @Override //오버라이딩 된건지 확인해주는 용도
    public void dance(){
        super.dance();
        wink();
    }

    private void wink(){

        System.out.println("윙크를 세게 갈깁니다.");
    }
}
