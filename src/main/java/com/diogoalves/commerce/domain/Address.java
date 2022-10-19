package com.diogoalves.commerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Address() {
    }

    public Address(Integer id, String address, String number, String complement, String neighborhood, String city, String state, String country, String cep, Client client) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.cep = cep;
        this.client = client;
    }
}
