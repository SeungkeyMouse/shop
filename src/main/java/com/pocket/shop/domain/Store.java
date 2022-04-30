package com.pocket.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Store{
   /* public Store(String name, Long latitude, Long longitude){
        this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;
    }
*/
    @Id
    @GeneratedValue
    @Column(name = "store_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "latitude")
    private Long latitude;

    @Column(name = "longitude")
    private Long longitude;


    //스토어:스티커=일대다
    @OneToMany(mappedBy = "store") //mappedBy는 Order테이블에있는 member에 의해 매핑됨(연관관계 주인은 order)
    private List<Sticker> stickers= new ArrayList<>();

    public Store(String name, long longitude, long latitude) {
      this.name= name;
      this.longitude=longitude;
      this.latitude=latitude;
    }
}
