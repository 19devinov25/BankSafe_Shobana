package com.edutech.progressive.dto;

import java.util.List;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.entity.Customers;

public class CustomerAccountInfo {
    private Customers customer;
    private List<Accounts> accounts;

    public CustomerAccountInfo() { }

    public CustomerAccountInfo(Customers customer, List<Accounts> accounts) {
        this.customer = customer;
        this.accounts = accounts;
    }

    public Customers getCustomer() { return customer; }
    public void setCustomer(Customers customer) { this.customer = customer; }

    public List<Accounts> getAccounts() { return accounts; }
    public void setAccounts(List<Accounts> accounts) { this.accounts = accounts; }
}


