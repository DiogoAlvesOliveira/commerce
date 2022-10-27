package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.controllers.api.ClientApi;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ClientController implements ClientApi {

    @Autowired
    IClientService clientService;

    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }

    public ResponseEntity<Client> findByEmail(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        return ResponseEntity.ok().body(client);
    }

    public ResponseEntity<Void> insertClient(@Valid @RequestBody ClientDTO clientDTO){
        Client client = clientService.fromDTO(clientDTO);
        client = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<Client>update(@Valid @PathVariable String email, @RequestBody ClientDTO clientDTO){
        clientService.update(clientDTO, email);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Client> delete(@PathVariable String email){
        clientService.delete(email);
        return ResponseEntity.noContent().build();
    }
}
