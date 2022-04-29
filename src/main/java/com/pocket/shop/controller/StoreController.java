package com.pocket.shop.controller;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class StoreController {
    private final StoreRepository storeRepository;
    private final StickerRepository stickerRepository;

    @GetMapping("/stores")
    Collection<Store> list(){//1. 전체 가게 목록 호출
        return storeRepository.findAll();
    }

    @GetMapping("/stores/{id}")
    ResponseEntity<?> getStore(@PathVariable Long id) {//2. (id 보내면) -> 특정 가게(스티커 포함) 중첩JSON
        Optional<Store> store = storeRepository.findById(id);
        return store.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}