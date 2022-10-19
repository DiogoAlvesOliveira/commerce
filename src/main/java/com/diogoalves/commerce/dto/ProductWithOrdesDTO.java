package com.diogoalves.commerce.dto;

import com.diogoalves.commerce.domain.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductWithOrdesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private List<OrderWithOffProductDTO> orders = new ArrayList<>();

    public ProductWithOrdesDTO() {
    }

    public ProductWithOrdesDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}
