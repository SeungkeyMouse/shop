package com.pocket.shop.controller;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickerController {
    private final StickerRepository stickerRepository;

    @PostMapping("/sticker")//3. Sticker(store객체, name, num) 보내주면 저장
    ResponseEntity<Sticker> createSticker(@RequestBody Sticker sticker) throws URISyntaxException {
        Sticker result = stickerRepository.save(sticker);
        return ResponseEntity.created(new URI("/api/store/" + result.getId()))
                .body(result);
    }
}