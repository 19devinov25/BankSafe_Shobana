package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.edutech.progressive.entity.Transactions;

public interface TransactionRepository  extends JpaRepository<Transactions, Integer> {
     List<Transactions> findByAccountsAccountId(int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions tr WHERE tr.accounts.accountId = :accountId")
    void deleteByAccountId(@Param("accountId") int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions tr WHERE tr.accounts.accountId in (Select acc.accountId from Accounts acc WHERE acc.customer.customerId = :customerId)")
    void deleteByCustomerId(@Param("customerId") int customerId);
}
