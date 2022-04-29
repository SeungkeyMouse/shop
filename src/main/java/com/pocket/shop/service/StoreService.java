package com.pocket.shop.service;

import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)//항상 트랜잭션 안에서 데이터 변경해야함!!!
@RequiredArgsConstructor//생성자주입 방식.
public class StoreService {

    private final StoreRepository storeRepository;//final 필수!!

    //조회
    public List<Store> findStores(){
        return storeRepository.findAll();
    }

    //{ Store : info, {Sticker : info} }
    public Optional<Store> findStoreStickers(Long id) {
        return storeRepository.findById(id);
    }
}

