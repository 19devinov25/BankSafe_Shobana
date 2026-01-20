package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.repository.AccountRepository;
@Service
public class AccountServiceImplJpa {
    @Autowired
 private AccountRepository accountRepository;
    public List<Accounts>getAllAccounts() throws SQLException{
        return null;
    }
    public List<Accounts> getAccountsByUser(int userId) throws SQLException{
        return null;
    }
    public Accounts getAccountById(int accountId) throws SQLException {
        return null;
    }
    public int addAccount(Accounts accounts) throws SQLException {
        return -1;
    }
    public void updateAccount(Accounts accounts) throws SQLException{
        
    }
    public void deleteAccount(int accountId) throws SQLException{

    }
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        return null;
    }
    
    
}