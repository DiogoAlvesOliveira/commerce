package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Product;
import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import com.diogoalves.commerce.repositories.ProductRepository;
import com.diogoalves.commerce.services.exceptions.ObjectNotFoundException;
import com.diogoalves.commerce.services.impl.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @TestConfiguration
    static class ProductServiceTestConfiguration{
        @Bean
        public ProductService productService(){
            return new ProductService();
        }
    }

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void findAllTest(){
        List<ProductDTO> productDTOList = productService.findAll();

        Assertions.assertEquals(2, productDTOList.size());
    }
    @Test
    public void findByIdTest(){
        Integer id = 1;
        ProductWithOrdesDTO product = productService.findById(id);

        Assertions.assertEquals(product.getId(), id);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void findByIdFailureTest(){
        Integer idUnexpected = 2;
        productService.findById(idUnexpected);
    }
    @Before
    public void setup(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(1, "Arroz", "Arroz 1kg", 10.00, 100);
        Product product2 = new Product(2, "Feijão", "Feijão 1kg", 15.00, 150);
        products.addAll(Arrays.asList(product1,product2));

        Mockito.when(productRepository.findAll()).thenReturn(products);
        Mockito.when(productRepository.findById(product1.getId())).thenReturn(Optional.of(product1));
    }
}
