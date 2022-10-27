package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.controllers.api.OrderApi;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.services.IClientService;
import com.diogoalves.commerce.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderApi {

    @Autowired
    IOrderService ordersService;

    @Autowired
    IClientService clientService;

    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orderDTO = ordersService.findAll();
        return ResponseEntity.ok().body(orderDTO);
    }

    public ResponseEntity<List<OrderDTO>> findByEmail(@PathVariable String email){
        Client client = clientService.findByEmail(email);
        List<OrderDTO> orderDTOList = ordersService.findByEmail(client);
        return ResponseEntity.ok().body(orderDTOList);
    }

}
