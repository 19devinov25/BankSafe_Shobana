package com.edutech.progressive.dao;

import java.util.List;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.dao.AccountDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public int addAccount(Accounts accounts) {
        String sql = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, accounts.getCustomerId());
            ps.setDouble(2, accounts.getBalance());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next())
                    return keys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert account", e);
        }
        return -1;
    }

    @Override
    public Accounts getAccountById(int accountId) {
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Accounts(
                            rs.getInt("account_id"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get account by id: " + accountId, e);
        }
        return null;
    }

    @Override
    public void updateAccount(Accounts accounts) {
        String sql = "UPDATE accounts SET customer_id = ?, balance = ? WHERE account_id = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accounts.getCustomerId());
            ps.setDouble(2, accounts.getBalance());
            ps.setInt(3, accounts.getAccountId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update account: " + accounts.getAccountId(), e);
        }
    }

    @Override
    public void deleteAccount(int accountId) {
        String sql = "DELETE FROM accounts WHERE account_id = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, accountId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete account: " + accountId, e);
        }
    }

    @Override
    public List<Accounts> getAllAccounts() {
        String sql = "SELECT * FROM accounts";
        List<Accounts> result = new ArrayList<>();
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(new Accounts(
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getDouble("balance")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch all accounts", e);
        }
        return result;
    }

    // Optional (if you add to interface later)
    public List<Accounts> getAllAccountsByCustomer(int customerId) {
        String sql = "SELECT account_id, customer_id, balance FROM accounts WHERE customer_id = ?";
        List<Accounts> result = new ArrayList<>();
        try (Connection con = DatabaseConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new Accounts(
                            rs.getInt("account_id"),
                            rs.getInt("customer_id"),
                            rs.getDouble("balance")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch accounts for customerId=" + customerId, e);
        }
        return result;
    }
}
