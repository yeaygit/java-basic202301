package org.example.beans;

import java.util.Objects;

public class Goods {
    // 필드를 설계 할 때 private, protected 제한자를 사용 (public 사용 안함)
    private final Long goodsId; //상품번호
    private String goodsName;//상품명
    private Integer price;//상품가격
    // 레퍼타입은 모든 변수의 기본값이 null

    //기본생성자는 필수
    public Goods(){
        this.goodsId=1L;
    }

    //내가 만든 다른 생성자
    public Goods(String goodsName, int price){
        this();
        this.goodsName=goodsName;
        this.price=price;
    }

    //setter, getter는 상황에 따라 선택
    //ex) 가격이 변경 하려면 setter필요
    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    @Override
    public String toString() {
        return String.format("상품번호 : %d, 상품명 : %s, 상품가격 : %d원",goodsId,goodsName,price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) && Objects.equals(goodsName, goods.goodsName) && Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, price);
    }
    //equals와 hash는 한 쌍임 둘다 맞춰줘야지 똑같아 짐
}
