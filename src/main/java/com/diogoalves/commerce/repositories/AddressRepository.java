package com.diogoalves.commerce.repositories;

import com.diogoalves.commerce.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Address obj WHERE obj.client.id = :clientId")
    List<Address> findByClient(@Param("clientId") Integer client_id);
}
