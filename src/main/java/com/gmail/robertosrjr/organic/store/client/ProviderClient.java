package com.gmail.robertosrjr.organic.store.client;

import com.gmail.robertosrjr.organic.store.controller.dto.FornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/provider-api/info/{uf}")
    FornecedorDto getInfoFornecedorByUf(@PathVariable String uf);
}
