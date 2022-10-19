package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.dto.CepDTO;
import com.diogoalves.commerce.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/cep")
public class CepResource {

    @Autowired
    CepService cepService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<AddressDTO> findCep(@PathVariable String cep) throws IOException {
        AddressDTO addressDTO = cepService.findCep(cep);
        return ResponseEntity.ok().body(addressDTO);
    }
}
