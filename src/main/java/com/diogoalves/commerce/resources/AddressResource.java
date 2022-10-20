package com.diogoalves.commerce.resources;


import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.services.AddressService;
import com.diogoalves.commerce.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
@Api( tags = "Addresses")
public class AddressResource {

    @Autowired
    ClientService clientService;

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/{email}")
    @ApiOperation(value="Save client address by email")
    public ResponseEntity<Void> insertAddress(@PathVariable String email, @RequestBody AddressDTO addressDTO){
        Client client = clientService.findByEmail(email);
        Address address = addressService.insertClientAddress(client, addressDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping(value = "/{email}")
    @ApiOperation(value="Returns all client addresses by email")
    public ResponseEntity<List<AddressDTO>> findByEmailAddress(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        List<AddressDTO> addressList = addressService.findByEmailAddress(client);
        return ResponseEntity.ok().body(addressList);
    }
}
