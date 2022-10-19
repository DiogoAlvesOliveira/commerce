package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
