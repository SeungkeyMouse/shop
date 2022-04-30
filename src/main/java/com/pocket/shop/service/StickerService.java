package com.pocket.shop.service;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StickerService {
    private final StickerRepository stickerRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public String addSticker(Long storeId, String name, Integer num){
        Store store = storeRepository.findById(storeId).orElseThrow();

        Sticker sticker = Sticker.createSticker(store,name,num);
        Sticker save = stickerRepository.save(sticker);

        return save.getName();
    }
}
