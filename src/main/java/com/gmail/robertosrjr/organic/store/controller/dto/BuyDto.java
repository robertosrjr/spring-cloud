package com.gmail.robertosrjr.organic.store.controller.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BuyDto {

    List<ItemDto> items;
    AddressDto address;
}
