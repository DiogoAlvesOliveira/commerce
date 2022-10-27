package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<ClientDTO> findAll();
    Client findByEmail(String email);
    Client insert(Client client);
    Client update(ClientDTO clientDTO, String email);
    void delete(String email);
    Client fromDTO(ClientDTO clientDTO);
}
