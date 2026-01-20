package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.repository.CustomerRepository;
import com.edutech.progressive.service.CustomerService;
@Service
public class CustomerServiceImplArraylist implements CustomerService {
    // @Autowired
    // CustomerRepository customerRepository;
    private static List<Customers> customersList = new ArrayList<>();

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        // return new ArrayList<>(customersList);
        return customersList;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        customersList.add(customers);
        return customersList.size();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // List<Customers> sortedList = new ArrayList<>(customersList);
        Collections.sort(customersList);
        return customersList;
    }

    @Override
    public void emptyArrayList() {
        customersList = new ArrayList<>();
    }

    // public Customers getCustomerById(int customerId) throws SQLException {
    //     for (Customers c : customersList) {
    //         if (c.getCustomerId() == customerId) return c;
    //     }
    //     return null;
    // }
}