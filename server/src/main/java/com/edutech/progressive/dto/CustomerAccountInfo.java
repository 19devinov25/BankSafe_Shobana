package com.edutech.progressive.dto;

import java.util.List;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.entity.Customers;

public class CustomerAccountInfo {

    private int customerId;
    private String customerName;
    private String email;
    private int accountId;
    private double balance;

    // Parameterized constructor
    public CustomerAccountInfo(int customerId, String customerName, String email, int accountId, double balance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.accountId = accountId;
        this.balance = balance;
    }

    // Default constructor (optional but useful)
    public CustomerAccountInfo() {}

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // toString()
    @Override
    public String toString() {
        return "CustomerAccountInfo{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
