package com.gmail.robertosrjr.organic.store.service;

import com.gmail.robertosrjr.organic.store.client.ProviderClient;
import com.gmail.robertosrjr.organic.store.controller.dto.BuyDto;
import com.gmail.robertosrjr.organic.store.controller.dto.FornecedorDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;

@Service
public class BuyService {

    @Value("${provider.url}")
    private String providerApi;

    @Autowired
    private ProviderClient providerClient;

    public void buy(BuyDto buy) {

        try {
            FornecedorDto providerDto =
                    this.providerClient.getInfoFornecedorByUf(buy.getAddress().getUf());
            System.out.println(providerDto);
        } catch (FeignException e) {
            e.printStackTrace();
        }
    }
}
