package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.repository.CustomerRepository;
@Service
public class CustomerServiceImplJpa {
    @Autowired
    CustomerRepository customerRepository;
    public List<Customers> getAllCustomers() throws SQLException{
        return new ArrayList<>();
    }
    public int addCustomer(Customers customers) throws SQLException{
        return -1;
    }
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        return new ArrayList<>();
    }
    public void updateCustomer(Customers customers) throws SQLException{

    }
    public void deleteCustomer(int customerId) throws SQLException{

    }
    public Customers getCustomerById(int customerId) throws SQLException{
        return null;
    }
    
}