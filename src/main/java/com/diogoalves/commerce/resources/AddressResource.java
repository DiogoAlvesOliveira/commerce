package com.diogoalves.commerce.resources;


import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.services.AddressService;
import com.diogoalves.commerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

    @Autowired
    ClientService clientService;

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/{email}")
    public ResponseEntity<Void> insertAddress(@PathVariable String email, @RequestBody AddressDTO addressDTO){
        Client client = clientService.findByEmail(email);
        Address address = addressService.insertClientAddress(client, addressDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
