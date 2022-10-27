package com.diogoalves.commerce.controllers.api;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
@Api( tags = "Clients")
public interface ClientApi {

    @GetMapping
    @ApiOperation(value="Returns all clients")
    ResponseEntity<List<ClientDTO>> findAll();

    @GetMapping(value = "/{email}")
    @ApiOperation(value="Return client by email")
    ResponseEntity<Client> findByEmail(@PathVariable String email);

    @PostMapping
    @ApiOperation(value="Save client")
    ResponseEntity<Void> insertClient(@Valid @RequestBody ClientDTO clientDTO);

    @PutMapping(value ="/{email}")
    @ApiOperation(value="Update client")
    ResponseEntity<Client>update(@Valid @PathVariable String email, @RequestBody ClientDTO clientDTO);

    @DeleteMapping(value="/{email}")
    @ApiOperation(value="Delete client")
    ResponseEntity<Client> delete(@PathVariable String email);
}
