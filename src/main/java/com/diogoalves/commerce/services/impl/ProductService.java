package com.diogoalves.commerce.services.impl;

import com.diogoalves.commerce.domain.Order;
import com.diogoalves.commerce.domain.Product;
import com.diogoalves.commerce.dto.*;
import com.diogoalves.commerce.repositories.ProductRepository;
import com.diogoalves.commerce.services.IProductService;
import com.diogoalves.commerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public ProductWithOrdesDTO findById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return this.fromProductWithOrdersDTO(product);
        throw new ObjectNotFoundException("Could not find Product id " + id);
    }

    private ProductWithOrdesDTO fromProductWithOrdersDTO(Optional<Product> product) {
        ProductWithOrdesDTO productDTO = new ProductWithOrdesDTO();
        if(product.isPresent() ) {
            productDTO.setId(product.get().getId());
            productDTO.setName(product.get().getName());
            productDTO.setDescription(product.get().getDescription());
            productDTO.setPrice(product.get().getPrice());
            if (product.get().getOrders() != null) {
                for (Order order : product.get().getOrders()) {
                    OrderWithOffProductDTO orderDTO = new OrderWithOffProductDTO();
                    orderDTO.setId(order.getId());
                    orderDTO.setInstant(order.getInstant());
                    orderDTO.setClient(new ClientDTO(order.getClient()));

                    productDTO.getOrders().add(orderDTO);
                }
            }
        }
        return productDTO;

    }
}
