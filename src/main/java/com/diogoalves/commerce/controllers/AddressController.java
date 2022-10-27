package com.diogoalves.commerce.controllers;


import com.diogoalves.commerce.controllers.api.AddressApi;
import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.services.IAddressService;
import com.diogoalves.commerce.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AddressController implements AddressApi {

    @Autowired
    IClientService clientService;

    @Autowired
    IAddressService addressService;

    public ResponseEntity<Void> insertAddress(@PathVariable String email, @RequestBody AddressDTO addressDTO){
        Client client = clientService.findByEmail(email);
        Address address = addressService.insertClientAddress(client, addressDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<List<AddressDTO>> findByEmailAddress(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        List<AddressDTO> addressList = addressService.findByEmailAddress(client);
        return ResponseEntity.ok().body(addressList);
    }
}
