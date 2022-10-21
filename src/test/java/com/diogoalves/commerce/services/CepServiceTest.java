package com.diogoalves.commerce.services;

import com.diogoalves.commerce.dto.AddressDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class CepServiceTest {
    @MockBean
    CepService cepService;

    @Test
    public void findCepTest() throws IOException {
        String cep = "52140310";
        AddressDTO addDTO = new AddressDTO();
        addDTO.setCep(cep);

        Mockito.when(cepService.findCep(cep)).thenReturn(addDTO);
        AddressDTO addressDTO = cepService.findCep(cep);

        Assertions.assertEquals(addressDTO.getCep(), cep);

    }
}
