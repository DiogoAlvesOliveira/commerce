package com.diogoalves.commerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderWithOffProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instant;
    private ClientDTO client;

    public OrderWithOffProductDTO() {
    }

    public OrderWithOffProductDTO(Integer id, Date instant, ClientDTO client) {
        this.id = id;
        this.instant = instant;
        this.client = client;
    }
}
