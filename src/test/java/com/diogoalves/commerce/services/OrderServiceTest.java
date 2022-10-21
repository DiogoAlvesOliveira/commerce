package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.domain.Order;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @TestConfiguration
    static class OrderServiceTestConfiguration{
        @Bean
        public OrderService orderService(){
            return new OrderService();
        }
    }

    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;

    @Test
    public void findAllTest(){
        List<OrderDTO> orderDTOList = orderService.findAll();

        Assertions.assertEquals(1, orderDTOList.size());
    }
    @Test
    public void findByEmailTest(){
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        List<OrderDTO> orderDTOList = orderService.findByEmail(client);

        Assertions.assertEquals(1, orderDTOList.size());
    }
    @Before
    public void setup(){
        List<Order> orders = new ArrayList<>();
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        Order order = new Order(1, now(), client);
        orders.add(order);

        Mockito.when(orderRepository.findAll()).thenReturn(orders);
        Mockito.when(orderRepository.findByClient(client.getId())).thenReturn(orders);
    }
}
