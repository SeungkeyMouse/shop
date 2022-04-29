package com.pocket.shop;

import com.pocket.shop.domain.Store;
import com.pocket.shop.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class Initializer implements CommandLineRunner {
    private final StoreRepository storeRepository;
    //예시 db 넣는용.
    @Override
    public void run(String... args) throws Exception {

    }
}
