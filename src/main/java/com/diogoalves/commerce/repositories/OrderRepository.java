package com.diogoalves.commerce.repositories;

import com.diogoalves.commerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Order obj WHERE obj.client.id = :clientId")
    List<Order> findByClient(@Param("clientId") Integer client_id);
}
