package com.diogoalves.commerce.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tb_orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instant;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToMany(mappedBy="orders")
    private List<Product> Products = new ArrayList<>();

    public Order() {
    }
}
