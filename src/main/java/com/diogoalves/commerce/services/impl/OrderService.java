package com.diogoalves.commerce.services.impl;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.domain.Order;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.repositories.OrderRepository;
import com.diogoalves.commerce.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return this.fromOrderDTO(orderList);
    }

    public List<OrderDTO> findByEmail(Client client) {
        List<Order> orderList = orderRepository.findByClient(client.getId());
        return this.fromOrderDTO(orderList);
    }
    private List<OrderDTO> fromOrderDTO(List<Order> orderList) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setInstant(order.getInstant());
            orderDTO.setClient(new ClientDTO(order.getClient()));
            if(order.getProducts() != null) {
                orderDTO.getProducts().addAll(order.getProducts());
            }
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }


}
