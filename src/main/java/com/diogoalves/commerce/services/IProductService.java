package com.diogoalves.commerce.services;

import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    List<ProductDTO> findAll();
    ProductWithOrdesDTO findById(Integer id);
}
