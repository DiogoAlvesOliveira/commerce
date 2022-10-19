package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    public Address insertClientAddress(Client client, AddressDTO addressDTO) {
        Address address = this.fromAddressDTO(addressDTO);
        address.setClient(client);
        return addressRepository.save(address);
    }
    public List<AddressDTO> findByEmailAddress(Client client) {
        List<Address> addressList = addressRepository.findByClient(client.getId());
        List<AddressDTO> addressDTOList = addressList.stream().map(obj -> fromAddress(obj)).collect(Collectors.toList());
        return addressDTOList;
    }
    private Address fromAddressDTO(AddressDTO addressDTO){
        Address address = new Address();
        address.setAddress(addressDTO.getAddress());
        address.setNumber(addressDTO.getNumber());
        address.setComplement(addressDTO.getComplement());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getUf());
        address.setCountry(addressDTO.getCountry());
        address.setCep(addressDTO.getCep());
        return address;
    }
    private AddressDTO fromAddress(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress(address.getAddress());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setComplement(address.getComplement());
        addressDTO.setNeighborhood(address.getNeighborhood());
        addressDTO.setCity(address.getCity());
        addressDTO.setUf(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setCep(address.getCep());
        return addressDTO;
    }
}
