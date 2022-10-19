package com.diogoalves.commerce.dto;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClientWithAddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String surname;
    @NotEmpty(message = "Mandatory completion")
    @Email
    private String email;
    private List<Address> Addresses = new ArrayList<>();

    public ClientWithAddressDTO() {
    }

    public ClientWithAddressDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.email = client.getEmail();
    }
}
