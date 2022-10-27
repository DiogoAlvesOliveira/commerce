package com.diogoalves.commerce.controllers.api;

import com.diogoalves.commerce.dto.ProductDTO;
import com.diogoalves.commerce.dto.ProductWithOrdesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Api( tags = "Products")
public interface ProductApi {

    @GetMapping
    @ApiOperation(value="Returns all products")
    ResponseEntity<List<ProductDTO>> findAll();

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Return product by id")
    ResponseEntity<ProductWithOrdesDTO> findById(@PathVariable Integer id);
}
