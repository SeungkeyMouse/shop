package com.pocket.shop;

import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import com.pocket.shop.service.StickerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class Initializer implements CommandLineRunner {
    private final StoreRepository storeRepository;
    @Autowired StickerService stickerService;
    //예시 db 넣는용.
    @Override
    public void run(String... args) throws Exception {
        //storeRepository.save(new Store("test2", 100L, 100L));
        //stickerService.addSticker(1L, "stickerSample", 100);
    }
}
