package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Accounts;

public interface AccountRepository  extends JpaRepository<Accounts, Integer>{

     List<Accounts> getAccountsByCustomerCustomerId(int customerId);
    Accounts findByAccountId(int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Accounts acc WHERE acc.customer.customerId = :customerId")
    void deleteByCustomerId(@Param("customerId") int customerId);
}
