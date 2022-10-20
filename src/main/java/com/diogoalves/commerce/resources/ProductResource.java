package com.diogoalves.commerce.resources;

import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import com.diogoalves.commerce.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Api( tags = "Products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping
    @ApiOperation(value="Returns all products")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productDTOList = productService.findAll();
        return ResponseEntity.ok().body(productDTOList);
    }
    @GetMapping(value = "/{id}")
    @ApiOperation(value="Return product by id")
    public ResponseEntity<ProductWithOrdesDTO> findById(@PathVariable Integer id) {
        ProductWithOrdesDTO product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
