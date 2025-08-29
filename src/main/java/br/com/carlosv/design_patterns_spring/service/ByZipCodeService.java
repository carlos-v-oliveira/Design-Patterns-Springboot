package br.com.carlosv.design_patterns_spring.service;

import br.com.carlosv.design_patterns_spring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ByZipCodeService {

    @GetMapping("/{cep}/json/")
    Address checkZipCode(@PathVariable("cep") String cep);
}
