package com.pocket.shop.service;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StickerService {
    private final StoreRepository storeRepository;
    private final StickerRepository stickerRepository;
    //조회
    public List<Sticker> findStickers(){
        return stickerRepository.findAll();
    }
    public Optional<Sticker> findOne(Long stickerId){
        return stickerRepository.findById(stickerId);
    }

}

