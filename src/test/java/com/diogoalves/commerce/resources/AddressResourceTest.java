package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.dto.CepDTO;
import com.diogoalves.commerce.services.AddressService;
import com.diogoalves.commerce.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressResourceTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ClientService clientService;
    @MockBean
    AddressService addressService;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    void findByEmailAddressTest() throws Exception {
        String email = "diogo.dream89@gmail.com";
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        Mockito.when(clientService.findByEmail(email)).thenReturn(client);
        this.mockMvc.perform(get("/address/{email}", email))
                .andExpect(status().isOk());
    }

    @Test
    void insertAddressTest() throws Exception {
        String email = "diogo.dream89@gmail.com";
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        CepDTO cepDTO = new CepDTO("Rua José Ramos de Vasconcelos",
                "1079", "Casa", "Pau Amarelo", "Paulista", "Pernambuco",
                "Brasil", "53433220");
        AddressDTO addressDTO = new AddressDTO(cepDTO);
        Address address = new Address(1, "Rua Testando",
                "1079", "Casa", "Pau Amarelo", "Paulista", "Pernambuco",
                "Brasil", "53433220", client);
        Mockito.when(clientService.findByEmail(email)).thenReturn(client);
        Mockito.when(addressService.insertClientAddress(client,addressDTO)).thenReturn(address);
        mockMvc.perform(post("/address/{email}", email)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(addressDTO)))
                .andExpect(status().isCreated());
    }

}
