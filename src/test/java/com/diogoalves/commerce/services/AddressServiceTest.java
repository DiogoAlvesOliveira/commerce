package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.repositories.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class AddressServiceTest {

    @TestConfiguration
    static class AddressServiceTestConfiguration{
        @Bean
        public AddressService addressService(){
            return new AddressService();
        }
    }

    @Autowired
    AddressService addressService;

    @MockBean
    AddressRepository addressRepository;

    @Test
    public void findByEmailAddressTest(){
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        List<AddressDTO> addressList = addressService.findByEmailAddress(client);

        Assertions.assertEquals(1, addressList.size());
    }

    @Test
    public void insertClientAddressTest(){
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        AddressDTO address = new AddressDTO();
        addressService.insertClientAddress(client, address);

        Mockito.verify(addressRepository, Mockito.times(1)).save(ArgumentMatchers.any(Address.class));
    }

    @Before
    public void setup(){
        List<Address> addresses = new ArrayList<>();
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        client.setId(1);
        Address address = new Address(1, "Rua Joaquim de França", "171", "casa",
                "Dois Unidos", "Recife", "PE", "Brasil","52140310",client);
        addresses.add(address);

        Mockito.when(addressRepository.findByClient(client.getId())).thenReturn(addresses);
    }
}
