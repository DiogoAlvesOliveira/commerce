package com.diogoalves.commerce.controllers.api;

import com.diogoalves.commerce.dto.AddressDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
@Api( tags = "Addresses")
public interface AddressApi {

    @PostMapping(value = "/{email}")
    @ApiOperation(value="Save client address by email")
    ResponseEntity<Void> insertAddress(@PathVariable String email, @RequestBody AddressDTO addressDTO);

    @GetMapping(value = "/{email}")
    @ApiOperation(value="Returns all client addresses by email")
    ResponseEntity<List<AddressDTO>> findByEmailAddress(@PathVariable String email);
}
