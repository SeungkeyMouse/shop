package com.pocket.shop.repository;

import com.pocket.shop.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    /*//JPQL 사용시 사용!
    private final EntityManager em;

    public void save(Store store){//저장
        em.persist(store);
    }
    public Store findOne(Long id){//단건 조회
        return em.find(Store.class, id);//(타입,PK)
    }

    public List<Store> findAll(){//전체 조회 :JPQL 사용('엔티티'를 조회)
        return em.createQuery("select s from Store s", Store.class)
                .getResultList();
    }*/
}
