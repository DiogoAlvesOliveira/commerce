package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.services.ClientService;
import com.diogoalves.commerce.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@Api( tags = "Orders")
public class OrderResources {

    @Autowired
    OrderService ordersService;

    @Autowired
    ClientService clientService;

    @GetMapping
    @ApiOperation(value="Returns all orders")
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orderDTO = ordersService.findAll();
        return ResponseEntity.ok().body(orderDTO);
    }

    @GetMapping(value = "/{email}")
    @ApiOperation(value="Return order by email")
    public ResponseEntity<List<OrderDTO>> findByEmail(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        List<OrderDTO> orderDTOList = ordersService.findByEmail(client);
        return ResponseEntity.ok().body(orderDTOList);
    }

}
