package org.example.inherit;

import org.example.basic.Dancer;

public class StreetDancer extends Dancer {

    //생성자 alt + insert
    public StreetDancer(String crewName, String myName) {
        super(crewName, myName);
    }

    @Override
    public void dance(){
        super.dance();
        System.out.println("비보잉을 합니다.");
    }
}
