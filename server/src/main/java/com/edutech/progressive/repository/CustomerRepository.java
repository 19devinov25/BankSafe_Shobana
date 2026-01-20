package com.edutech.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.edutech.progressive.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers,Integer>  {
        Customers findByCustomerId(@Param("customerId") int customerId);

    void deleteByCustomerId(@Param("customerId") int customerId);

    Customers findByEmail(@Param("email") String email);

    Customers findByUsername(String username);

}
