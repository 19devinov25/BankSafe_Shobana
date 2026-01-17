package com.edutech.progressive.service.impl;



import com.edutech.progressive.entity.Accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import com.edutech.progressive.entity.Accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountServiceImplArraylist {

    // In-memory list to store account objects.
    private static List<Accounts> accountsList = new ArrayList<>();

    /**
     * Returns the list of all accounts stored in the in-memory list.
     * Return a copy to avoid external mutation on internal list.
     */
    public List<Accounts> getAllAccounts() {
        return new ArrayList<>(accountsList);
    }

    /**
     * Adds a new account to the in-memory list and returns the updated size of the list.
     */
    public int addAccount(Accounts accounts) {
        accountsList.add(accounts);
        return accountsList.size();
    }

    /**
     * Returns all accounts sorted in ascending order based on account balance.
     * Uses Accounts.compareTo (natural ordering).
     */
    public List<Accounts> getAllAccountsSortedByBalance() {
        List<Accounts> copy = new ArrayList<>(accountsList);
        Collections.sort(copy);
        return copy;
    }

    /**
     * Retrieves an account by its id; returns null if not found (expected by tests).
     */
    public Accounts getAccountById(int accountId) {
        for (Accounts a : accountsList) {
            if (a.getAccountId() == accountId) return a;
        }
        return null;
    }

    /**
     * Clears the in-memory accounts list by reinitializing it.
     */
    public void emptyArrayList() {
        accountsList = new ArrayList<>();
    }
}
