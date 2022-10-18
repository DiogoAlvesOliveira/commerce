package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
