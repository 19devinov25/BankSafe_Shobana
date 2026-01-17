package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Customers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import com.edutech.progressive.entity.Customers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerServiceImplArraylist {

    // In-memory list used to store customer objects.
    private static List<Customers> customersList = new ArrayList<>();

    /**
     * Returns all customers currently stored in the in-memory list.
     */
    public List<Customers> getAllCustomers() throws SQLException {
        return new ArrayList<>(customersList);
    }

    /**
     * Adds a new customer to the in-memory list and returns the updated number of customers.
     */
    public int addCustomer(Customers customers) throws SQLException {
        customersList.add(customers);
        return customersList.size();
    }

    /**
     * Returns all customers sorted in ascending order by customer name.
     * Uses Customers.compareTo (natural ordering).
     */
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> copy = new ArrayList<>(customersList);
        Collections.sort(copy);
        return copy;
    }

    /**
     * Retrieves a customer by id; returns null if not found (expected by tests).
     */
    public Customers getCustomerById(int customerId) throws SQLException {
        for (Customers c : customersList) {
            if (c.getCustomerId() == customerId) return c;
        }
        return null;
    }

    /**
     * Clears all customers by reinitializing the in-memory list.
     */
    public void emptyArrayList() {
        customersList = new ArrayList<>();
    }
}
