package com.edutech.progressive.entity;

public class Customers implements Comparable<Customers> {
    private int customerId; // Unique identifier
    private String name; // Full name
    private String email; // Email
    private String username; // Username
    private String password; // Password
    private String role; // Keep nullable for now

    public Customers() {
    }

    public Customers(int customerId, String name, String email, String username, String password) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int compareTo(Customers otherCustomers) {
        // if (this.name == null && otherCustomers.name == null) return 0;
        // if (this.name == null) return -1;
        // if (otherCustomers.name == null) return 1;
        return this.name.compareToIgnoreCase(otherCustomers.name);
    }
}
