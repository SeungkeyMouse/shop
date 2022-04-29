package com.pocket.shop.repository;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long> {
    /*private final EntityManager em;
    public void save(Sticker sticker) {em.persist(sticker);}
    public Sticker findOne(Long id) { return em.find(Sticker.class, id);}
    public List<Sticker> findAll(){
        return em.createQuery("select st from Sticker st", Sticker.class)
                .getResultList();
    }*/
}
