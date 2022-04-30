package com.pocket.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sticker {
    @Id
    @GeneratedValue
    @Column(name = "sticker_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//주문:멤버 = 다대일관계
    @JoinColumn(name = "store_id")//추가로 매핑을 이렇게 하면 외래키 알려줌
    @JsonIgnore
    private Store store;

    @Column(name = "sticker_name")
    private String name;

    @Column(name = "sticker_num")
    private Integer num;

    //==연관관계 메서드==//
    public void setStore(Store store) {
        this.store = store;
        store.getStickers().add(this);
    }

    //==생성 메서드==//
    public static Sticker createSticker(Store store, String name, int num) {
        Sticker sticker = new Sticker();
        sticker.setStore(store);
        sticker.setName(name);
        sticker.setNum(num);

        return sticker;
    }
}
