package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.controllers.api.CepApi;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.services.ICepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CepController implements CepApi {

    @Autowired
    ICepService iCepService;

    public ResponseEntity<AddressDTO> findCep(@PathVariable String cep) throws IOException {
        AddressDTO addressDTO = iCepService.findCep(cep);
        return ResponseEntity.ok().body(addressDTO);
    }
}
