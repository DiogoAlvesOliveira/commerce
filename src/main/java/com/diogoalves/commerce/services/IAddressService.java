package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {

    Address insertClientAddress(Client client, AddressDTO addressDTO);
    List<AddressDTO> findByEmailAddress(Client client);
}
