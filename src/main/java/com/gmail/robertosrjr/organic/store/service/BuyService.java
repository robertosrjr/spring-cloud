package com.gmail.robertosrjr.organic.store.service;

import com.gmail.robertosrjr.organic.store.controller.dto.BuyDto;
import com.gmail.robertosrjr.organic.store.controller.dto.FornecedorDto;
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

    @Autowired
    private RestTemplate client;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${provider.url}")
    private String providerApi;

    public void buy(BuyDto buy) {

        try {

            ResponseEntity<FornecedorDto> response =
                    client.exchange(providerApi.concat("/provider/".concat(buy.getAddress().getUf())),
                            HttpMethod.GET,null, FornecedorDto.class);

            discoveryClient.getInstances("provider").stream()
                    .forEach(provider -> {
                        System.out.println("localhost:" + provider.getPort());
                    });
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }
}
