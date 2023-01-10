package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

public class Main {
    public static void main(String[] args) {
        /*
        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕"); //생성자에 마우스 두고 ctrl+alt+v 하면 타입과 생성자 자동생성
        dancer.dance();


        IdolDancer idolDancer=new IdolDancer("AB6IX","이대휘");


        StreetDancer streetDancer = new StreetDancer("길거리춤꾼들", "박격포");
        idolDancer.dance();

        System.out.println();
        streetDancer.dance();
         */
        Dancer idolDancer1=new IdolDancer("아이돌팀1","아이돌1");
        Dancer idolDancer2=new IdolDancer("아이돌팀2","아이돌2");
        Dancer idolDancer3=new IdolDancer("아이돌팀3","아이돌3");

        Dancer streetDancer1= new StreetDancer("스트릿팀1","스트릿댄서1");
        Dancer streetDancer2= new StreetDancer("스트릿팀2","스트릿댄서2");
        Dancer streetDancer3= new StreetDancer("스트릿팀3","스트릿댄서3");

        PerformanceTeam team= new PerformanceTeam();

        team.joinDancer(idolDancer1);
        team.joinDancer(streetDancer3);
        team.joinDancer(idolDancer2);
        team.joinDancer(streetDancer1);
    }
}