package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.dto.CepDTO;
import com.diogoalves.commerce.services.impl.CepService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CepControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CepService cepService;

    @Test
    void findCepTest() throws Exception {
        String cep = "53433220";
        CepDTO cepDTO = new CepDTO("Rua José Ramos de Vasconcelos",
                "1079", "Casa", "Pau Amarelo", "Paulista", "Pernambuco",
                "Brasil", "53433220");
        AddressDTO addressDTO = new AddressDTO(cepDTO);
        Mockito.when(cepService.findCep(cep)).thenReturn(addressDTO);
        this.mockMvc.perform(get("/cep/{cep}", cep))
                .andExpect(status().isOk());
    }
}
