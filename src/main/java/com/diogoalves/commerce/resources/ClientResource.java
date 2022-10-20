package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@Api( tags = "Clients")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    @ApiOperation(value="Returns all clients")
    public ResponseEntity<List<ClientDTO>> findAll(){
        List<ClientDTO> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{email}")
    @ApiOperation(value="Return client by email")
    public ResponseEntity<Client> findByEmail(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        return ResponseEntity.ok().body(client);
    }
    @PostMapping
    @ApiOperation(value="Save client")
    public ResponseEntity<Void> insertClient(@Valid @RequestBody ClientDTO clientDTO){
        Client client = clientService.fromDTO(clientDTO);
        client = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value ="/{email}")
    @ApiOperation(value="Update client")
    public ResponseEntity<Client>update(@Valid @PathVariable String email, @RequestBody ClientDTO clientDTO){
        Client client = clientService.update(clientDTO, email);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value="/{email}")
    @ApiOperation(value="Delete client")
    public ResponseEntity<Client> delete(@PathVariable String email){
        clientService.delete(email);
        return ResponseEntity.noContent().build();
    }
}
