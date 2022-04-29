package com.pocket.shop.controller;

import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StoreRepository;
import com.pocket.shop.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private  final StoreService storeService;

    @GetMapping("/stores")
    public String list(Model model){
        List<Store> stores = storeService.findStores();
        String str= "";
        for(Store s : stores) {
            str += s.getName() + ", ";
        }
        model.addAttribute("data", str);
        return "hello";
    }

    @GetMapping("/stores/{id}")//https://gorokke.tistory.com/202
    public void store_stickerList(@PathVariable Long id, Model model){
        storeService.findStoreStickers(id);
    }
}