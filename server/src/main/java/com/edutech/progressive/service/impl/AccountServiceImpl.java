package com.edutech.progressive.service.impl;




import com.edutech.progressive.dao.AccountDAO;
import com.edutech.progressive.dao.AccountDAOImpl;
import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAOImpl accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    @Override
    public Accounts getAccountById(int accountId) {
        return accountDAO.getAccountById(accountId);
    }

    @Override
    public int addAccount(Accounts accounts) {
        return accountDAO.addAccount(accounts);
    }

    @Override
    public void updateAccount(Accounts accounts) {
        accountDAO.updateAccount(accounts);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountDAO.deleteAccount(accountId);
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() {
        List<Accounts> all = new ArrayList<>(accountDAO.getAllAccounts());
        Collections.sort(all); // Accounts implements Comparable by balance
        return all;
    }
}
