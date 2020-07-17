package com.gmail.robertosrjr.organic.store.service;

import com.gmail.robertosrjr.organic.store.controller.dto.BuyDto;
import com.gmail.robertosrjr.organic.store.controller.dto.FornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

@Service
public class BuyService {

    @Autowired
    private RestTemplate client;

    @Value("${provider.url}")
    private String providerApi;

    public void buy(BuyDto buy) {

        try {

            ResponseEntity<FornecedorDto> response =
                    client.exchange(providerApi.concat("/provider/".concat(buy.getAddress().getUf())),
                            HttpMethod.GET,null, FornecedorDto.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }
}
