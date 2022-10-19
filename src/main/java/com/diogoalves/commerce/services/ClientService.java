package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.repositories.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO> findAll() {
        List<Client> clientList = clientRepository.findAll();
        List<ClientDTO> clientDTOList = clientList.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
        return clientDTOList;
    }

    public Client findByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new ObjectNotFoundException("Client not found! ", "Client");
        }
        return client;
    }

}
