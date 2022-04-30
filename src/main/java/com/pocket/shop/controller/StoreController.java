package com.pocket.shop.controller;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import com.pocket.shop.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class StoreController {
    private final StoreRepository storeRepository;
    private final StickerRepository stickerRepository;
    private final StoreService storeService;
    @GetMapping("/stores")
    Collection<Store> list(){//1. 전체 가게 목록 호출
        return storeRepository.findAll();
    }

    @GetMapping("/stores/{id}")//요청 에시 ==> http://localhost:8080/api/stores/1
    ResponseEntity<?> getStore_StickerCount(@PathVariable Long id) {//2. (스토어id 보내면) -> 스티커 포함 중첩JSON
        return ResponseEntity.ok(storeService.find(id));
    }
}