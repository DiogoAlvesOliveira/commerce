package com.diogoalves.commerce.services;

import com.diogoalves.commerce.dto.AddressDTO;
import com.diogoalves.commerce.dto.CepDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class CepService {

    @Value("${default.url}")
    private String viaCep;

    public AddressDTO findCep(String cep) throws IOException {
        URL urlCep = new URL( viaCep + cep +"/json");
        URLConnection connection = urlCep.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String cepLine = "";
        StringBuilder jsonCep = new StringBuilder();
        while ((cepLine=bufferedReader.readLine()) != null) {
            jsonCep.append(cepLine);
        }
        CepDTO cepDTO = new Gson().fromJson(jsonCep.toString(), CepDTO.class);
        AddressDTO addressDTO = new AddressDTO(cepDTO);

        return addressDTO;
    }
}
