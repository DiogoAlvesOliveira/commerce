package com.diogoalves.commerce.services.impl;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import com.diogoalves.commerce.repositories.ClientRepository;
import com.diogoalves.commerce.services.IClientService;
import com.diogoalves.commerce.services.exceptions.DataIntegrityException;
import com.diogoalves.commerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO> findAll() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    public Client findByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new ObjectNotFoundException("Could not find Client email " + email);
        }
        return client;
    }
    public Client insert(Client client) {
        return clientRepository.save(client);
    }
    public Client update(ClientDTO clientDTO, String email) {
        Client client = this.findByEmail(email);
        updateData(client, clientDTO);
        return clientRepository.save(client);
    }
    public void delete(String email) {
        try{
            Client client = this.findByEmail(email);
            clientRepository.deleteById(client.getId());
        }catch (Exception e){
            throw new DataIntegrityException("It is not possible to delete a client who has an order or an address");
        }
    }
    public Client fromDTO(ClientDTO clientDTO) {
        return new Client(clientDTO.getName(), clientDTO.getSurname(), clientDTO.getEmail());
    }
    private void updateData(Client client, ClientDTO clientDTO) {
        if(clientDTO.getId() != null) client.setId(clientDTO.getId());
        if(clientDTO.getName() != null) client.setName(clientDTO.getName());
        if(clientDTO.getSurname() != null) client.setSurname(clientDTO.getSurname());
        if(clientDTO.getEmail() != null) client.setEmail(clientDTO.getEmail());
    }
}
