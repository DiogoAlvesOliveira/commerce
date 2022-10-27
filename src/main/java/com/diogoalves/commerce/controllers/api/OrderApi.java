package com.diogoalves.commerce.controllers.api;

import com.diogoalves.commerce.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@Api( tags = "Orders")
public interface OrderApi {

    @GetMapping
    @ApiOperation(value="Returns all orders")
    ResponseEntity<List<OrderDTO>> findAll();

    @GetMapping(value = "/{email}")
    @ApiOperation(value="Return order by email")
    ResponseEntity<List<OrderDTO>> findByEmail(@PathVariable String email);
}
