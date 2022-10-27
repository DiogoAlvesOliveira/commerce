package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    List<OrderDTO> findAll();
    List<OrderDTO> findByEmail(Client client);
}
