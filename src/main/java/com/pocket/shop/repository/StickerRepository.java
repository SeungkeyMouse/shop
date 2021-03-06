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

}
