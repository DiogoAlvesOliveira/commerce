package com.diogoalves.commerce.controllers.api;

import com.diogoalves.commerce.dto.AddressDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/cep")
@Api( tags = "Zip code")
public interface CepApi {

    @GetMapping(value = "/{cep}")
    @ApiOperation(value="Return address by zip code")
    ResponseEntity<AddressDTO> findCep(@PathVariable String cep) throws IOException;
}
