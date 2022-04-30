package com.pocket.shop.controller;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.service.StickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
public class StickerController {
    private final StickerService stickerService;

    @PostMapping("/sticker")//3. Sticker(store객체, name, num) 보내주면 저장
        String createSticker(@RequestParam("sticker") Sticker sticker) throws URISyntaxException {
        return stickerService.addSticker(sticker.getStore().getId(), sticker.getName(), sticker.getNum());
    }
}