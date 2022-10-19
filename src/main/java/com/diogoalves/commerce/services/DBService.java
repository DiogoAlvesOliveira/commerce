package com.diogoalves.commerce.services;

import com.diogoalves.commerce.domain.Address;
import com.diogoalves.commerce.domain.Client;
import com.diogoalves.commerce.domain.Order;
import com.diogoalves.commerce.domain.Product;
import com.diogoalves.commerce.repositories.AddressRepository;
import com.diogoalves.commerce.repositories.ClientRepository;
import com.diogoalves.commerce.repositories.OrderRepository;
import com.diogoalves.commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;
    public void instantiateTestDatabase() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Client client1 = new Client(null, "Diogo", "Alves", "diogo.dream89@gmail.com");
        Client client2 = new Client(null, "Miguel", "Alves", "miguel@gmail.com");

        Address address1 = new Address(null, "Rua José Ramos de Vasconcelos",
                "1079", "Casa", "Pau Amarelo", "Paulista", "Pernambuco",
                "Brasil", "53433220", client1);
        Address address2 = new Address(null, "Rua Joaquim de França",
                "171", "Casa","Dois Unidos", "Recife", "Pernambuco",
                "Brasil", "52140310", client2);

        Product product1 = new Product(null, "Notebook Dell", "Notebook dell i7, 16RAM", 5000.00, 20);
        Product product2 = new Product(null, "Mouse", "Mouse gamer", 50.00, 70);

        Order order1 = new Order(null, sdf.parse("18/10/2022 12:32"),client1 );
        Order order2 = new Order(null, sdf.parse("17/10/2022 18:48"),client1 );

        order1.getProducts().addAll(Arrays.asList(product1, product2));
        order2.getProducts().addAll(Arrays.asList(product1, product2));

        product1.getOrders().addAll(Arrays.asList(order1, order2));
        product2.getOrders().addAll(Arrays.asList(order1, order2));

        clientRepository.saveAll(Arrays.asList(client1, client2));
        addressRepository.saveAll(Arrays.asList(address1, address2));
        orderRepository.saveAll(Arrays.asList(order1, order2));
        productRepository.saveAll(Arrays.asList(product1, product2));

    }
}
