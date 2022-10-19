package com.diogoalves.commerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tb_clients")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;

    @Column(unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy="client")
    private List<Address> Addresses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Order> Orders = new ArrayList<>();

    public Client() {}

    public Client(String name, String surname, String email) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
