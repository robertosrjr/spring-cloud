package com.gmail.robertosrjr.organic.store.controller;

import com.gmail.robertosrjr.organic.store.controller.dto.BuyDto;
import com.gmail.robertosrjr.organic.store.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping
    public ResponseEntity<?> buy(@RequestBody BuyDto buyDto) {

        this.buyService.buy(buyDto);
        return ResponseEntity.ok().build();
    }
}
