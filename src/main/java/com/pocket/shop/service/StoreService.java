package com.pocket.shop.service;

import com.pocket.shop.domain.ResponseSticker;
import com.pocket.shop.domain.Sticker;
import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StickerRepository;
import com.pocket.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {
    private final StickerRepository stickerRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public List<ResponseSticker> find(Long storeId){
        Store store = storeRepository.findById(storeId).orElseThrow();

        List<Sticker> stickers = store.getStickers();
        Map<Integer, Integer> num_count = new HashMap<>();
        Map<Integer, String> num_name = new HashMap<>();
        for(Sticker sticker : stickers) {//스티커 num에 대해서 count값 증가
            Integer stickerNum = sticker.getNum();
            num_count.put(stickerNum, num_count.getOrDefault(stickerNum, 0)+1);
            num_name.put(stickerNum,sticker.getName());
        }

        List<ResponseSticker> result = new LinkedList<>();
        for(Integer key : num_count.keySet()){
            ResponseSticker res = new ResponseSticker();
            res.setNum(key);
            res.setName(num_name.get(key));
            res.setCount(num_count.get(key));
            result.add(res);
        }

        return result;
    }
}
