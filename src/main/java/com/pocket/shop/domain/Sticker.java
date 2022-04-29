package com.pocket.shop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED )
public class Sticker {
    @Id
    @GeneratedValue
    @Column(name = "sticker_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//주문:멤버 = 다대일관계
    @JoinColumn(name = "store_id")//추가로 매핑을 이렇게 하면 외래키 알려줌
    private Store store;

    @Column(name = "sticker_name")
    private String name;

    @Column(name = "sticker_num")
    private int num;


    //==연관관계 메서드==//
    public void setStore(Store store) {
        this.store = store;
        store.getStickers().add(this);
    }

    //==생성 메서드==//
    public static Sticker createSticker(Store store, String name, int num) {
        Sticker sticker = new Sticker();
        sticker.setStore(store);
        sticker.setNum(num);

        return sticker;
    }


    //== 조회 로직 ==//
    /**
     * 전체 주문 가격 조회
     */
    /*public int getTotalPrice(){
       *//* int totalPrice = 0;

        for(OrderItem orderItem : orderItems){
            totalPrice +=orderItem.getTotalPrice();
        }
        return totalPrice;*//*
        return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
    }
*/
}
