package com.diogoalves.commerce.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;
    private String country;
    private String cep;

    public AddressDTO() {
    }

    public AddressDTO(CepDTO cepDTO) {
        this.address = cepDTO.getLogradouro();
        this.number = cepDTO.getNumero();
        this.complement = cepDTO.getComplemento();
        this.neighborhood = cepDTO.getBairro();
        this.city = cepDTO.getLocalidade();
        this.uf = cepDTO.getUf();
        this.country = cepDTO.getPais();
        this.cep = cepDTO.getCep();
    }
}
