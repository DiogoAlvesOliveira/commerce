package com.diogoalves.commerce.dto;

import com.diogoalves.commerce.domain.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instant;
    private ClientDTO client;
    private List<Product> Products = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Date instant, ClientDTO client) {
        this.instant = instant;
        this.client = client;
    }
}
