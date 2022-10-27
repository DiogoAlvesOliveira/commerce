package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.repositories.ClientRepository;
import com.diogoalves.commerce.services.exceptions.DataIntegrityException;
import com.diogoalves.commerce.services.exceptions.ObjectNotFoundException;
import com.diogoalves.commerce.services.impl.ClientService;
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
public class ClientServiceTest {

    @TestConfiguration
    static class ClientServiceTestConfiguration{
        @Bean
        public ClientService clientService(){
            return new ClientService();
        }
    }

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    @Test
    public void findAllTest() {
        List<ClientDTO> clients = clientService.findAll();

        Assertions.assertEquals(1, clients.size());
    }

    @Test
    public void findByEmailTest(){
        String email = "diogo.dream89@gmail.com";
        Client client = clientService.findByEmail(email);

        Assertions.assertEquals(client.getEmail(), email);
    }
    @Test(expected= ObjectNotFoundException.class)
    public void findByEmailFailureTest(){
        String email = "diogo@gmail.com";
        clientService.findByEmail(email);
    }

    @Test
    public void insertTest(){
        Client client = new Client("Miguel", "Oliveira", "miguel@gmail.com");
        clientService.insert(client);

        Mockito.verify(clientRepository, Mockito.times(1)).save(ArgumentMatchers.any(Client.class));
    }

    @Test
    public void updateTest(){
        String email = "diogo.dream89@gmail.com";
        Client client = new Client("Luiz", "Alves", "luiz89@gmail.com");
        ClientDTO clientDTO =  new ClientDTO(client);

        clientService.update(clientDTO, email);

        Assertions.assertEquals("luiz89@gmail.com", client.getEmail() );
    }
    @Test
    public void deleteTest(){
        String email = "diogo.dream89@gmail.com";
        clientService.delete(email);

        Mockito.verify(clientRepository, Mockito.times(1)).deleteById(ArgumentMatchers.any());
    }

    @Test(expected=DataIntegrityException.class)
    public void deleteFailureTest(){
        String email = "diogo@gmail.com";
        clientService.delete(email);
    }

    @Before
    public void setup(){
        List<Client> clients = new ArrayList<>();
        Client client = new Client("Diogo", "Alves", "diogo.dream89@gmail.com");
        clients.add(client);

        Mockito.when(clientRepository.findAll()).thenReturn(clients);
        Mockito.when(clientRepository.findByEmail(client.getEmail())).thenReturn(client);
    }
}
