package com.diogoalves.commerce.services;

import com.diogoalves.commerce.dto.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICepService {

    AddressDTO findCep(String cep);
}
