package com.diogoalves.commerce.controllers;

import com.diogoalves.commerce.controllers.api.ProductApi;
import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import com.diogoalves.commerce.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    IProductService productService;

    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productDTOList = productService.findAll();
        return ResponseEntity.ok().body(productDTOList);
    }
    public ResponseEntity<ProductWithOrdesDTO> findById(@PathVariable Integer id) {
        ProductWithOrdesDTO product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
