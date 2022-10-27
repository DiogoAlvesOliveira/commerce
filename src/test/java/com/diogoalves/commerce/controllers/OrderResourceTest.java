package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.OrderDTO;
import com.diogoalves.commerce.services.impl.ClientService;
import com.diogoalves.commerce.services.impl.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderResourceTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    OrderService orderService;
    @MockBean
    ClientService clientService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAllTest() throws Exception {
        List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
        Mockito.when(orderService.findAll()).thenReturn(ordersDTO);
        this.mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void findByEmailTest() throws Exception {
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        List<OrderDTO> ordersDTO = new ArrayList<OrderDTO>();
        Mockito.when(clientService.findByEmail(client.getEmail())).thenReturn(client);
        Mockito.when(orderService.findByEmail(client)).thenReturn(ordersDTO);
        this.mockMvc.perform(get("/orders/{email}", client.getEmail()))
                .andExpect(status().isOk());
    }

}
