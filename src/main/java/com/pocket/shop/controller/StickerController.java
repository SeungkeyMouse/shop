package com.pocket.shop.controller;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.service.StickerService;
import com.pocket.shop.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickerController {
    private final StickerService stickerService;
    private final StoreService storeService;

    @GetMapping("/stickers")//스티커 전체 불러올일은없는듯
    public String list(Model model) {
        List<Sticker> stickers = stickerService.findStickers();
        model.addAttribute("data", stickers);
        return "hello";
    }

    @PostMapping("/sticker")
    public void createSticker(){
        //stickerService.cre
    }
}