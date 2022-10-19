package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.domain.Order;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = this.fromOrderDTO(orderList);
        return orderDTOList;
    }

    public List<OrderDTO> findByEmail(Client client) {
        List<Order> orderList = orderRepository.findByClient(client.getId());
        List<OrderDTO> orderDTOList = this.fromOrderDTO(orderList);
        return orderDTOList;
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
