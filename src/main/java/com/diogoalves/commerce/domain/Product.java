package com.diogoalves.commerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tb_products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double price;
    private Integer stock;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUCTS_ORDERS", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(Integer id, String name, String description, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
