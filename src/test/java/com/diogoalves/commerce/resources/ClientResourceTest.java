package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.services.ClientService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientResourceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientService clientService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAllTest() throws Exception {
        List<ClientDTO> clientDTOList = new ArrayList<>();
        ClientDTO clientDTO = new ClientDTO();
        clientDTOList.add(clientDTO);

        Mockito.when(clientService.findAll()).thenReturn(clientDTOList);
        this.mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void findByEmailTest() throws Exception {
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");

        Mockito.when(clientService.findByEmail(client.getEmail())).thenReturn(client);
        this.mockMvc.perform(get("/clients/{email}", client.getEmail()))
                .andExpect(status().isOk());

    }
    @Test
    void insertClientTest() throws Exception {
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        ClientDTO clientDTO = new ClientDTO(client);

        Mockito.when(clientService.fromDTO(clientDTO)).thenReturn(client);
        Mockito.when(clientService.insert(client)).thenReturn(client);
        mockMvc.perform(post("/clients")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(clientDTO)))
                        .andExpect(status().isCreated());
    }

    @Test
    void updateTest() throws Exception {
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        ClientDTO clientDTO = new ClientDTO(client);

        Mockito.when(clientService.update(clientDTO, client.getEmail())).thenReturn(client);
        mockMvc.perform(put("/clients/{email}", client.getEmail())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(clientDTO)))
                        .andExpect(status().isNoContent());
    }
    @Test
    void deleteTest() throws Exception {
        String email = "diogo.drea89@gmail.com";

        mockMvc.perform(delete("/clients/{email}", email))
                        .andExpect(status().isNoContent());
    }
}
