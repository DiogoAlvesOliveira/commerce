package com.diogoalves.commerce.services.impl;

import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.dto.CepDTO;
import com.diogoalves.commerce.services.ICepService;
import com.diogoalves.commerce.services.exceptions.ObjectNotFoundException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class CepService implements ICepService {

    @Value("${default.url}")
    private String viaCep;

    public AddressDTO findCep(String cep) {
        try {
            URL urlCep = new URL(viaCep + cep + "/json");
            URLConnection connection = urlCep.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            StringBuilder jsonCep = new StringBuilder();
            bufferedReader.lines().forEach(line -> jsonCep.append(line.trim()));

            CepDTO cepDTO = new Gson().fromJson(jsonCep.toString(), CepDTO.class);
            return new AddressDTO(cepDTO);
        } catch (Exception e) {
            throw new ObjectNotFoundException("Could not find zip code "+ cep);
        }
    }
}
