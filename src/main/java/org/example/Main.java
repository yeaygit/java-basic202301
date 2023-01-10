package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;

public class Main {
    public static void main(String[] args) {
        /*
        Dancer dancer = new Dancer("총알탄소년단", "춤신춤왕"); //생성자에 마우스 두고 ctrl+alt+v 하면 타입과 생성자 자동생성
        dancer.dance();
         */

        IdolDancer idolDancer=new IdolDancer("AB6IX","이대휘");


        StreetDancer streetDancer = new StreetDancer("길거리춤꾼들", "박격포");
        idolDancer.dance();

        System.out.println();
        streetDancer.dance();

    }
}