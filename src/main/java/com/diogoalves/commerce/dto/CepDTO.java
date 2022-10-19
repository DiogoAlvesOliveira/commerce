package com.diogoalves.commerce.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CepDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String pais;
    private String cep;

    public CepDTO() {
    }

    public CepDTO(String logradouro, String numero, String complemento, String bairro, String localidade, String uf, String pais, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.pais = pais;
        this.cep = cep;
    }
}
