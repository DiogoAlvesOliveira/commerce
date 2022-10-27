package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import com.diogoalves.commerce.services.impl.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ProductService productService;

    @Test
    void findAllTest() throws Exception {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Mockito.when(productService.findAll()).thenReturn(productDTOList);
        this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void findByIdTest() throws Exception {
        Integer id = 1;
        ProductWithOrdesDTO product = new ProductWithOrdesDTO();

        Mockito.when(productService.findById(id)).thenReturn(product);

        this.mockMvc.perform(get("/products/{id}", id))
                .andExpect(status().isOk());
    }

}
