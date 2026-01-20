// package com.edutech.progressive.service.impl;

// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.edutech.progressive.entity.Accounts;
// @Service
// public class AccountServiceImplArraylist {
//     private static List<Accounts> accountList = new ArrayList<>();

//     public AccountServiceImplArraylist() {

//     }

//     public List<Accounts> getAllAccounts() throws SQLException {
//         // return new ArrayList<>(accountList);
//         return accountList;
//     }

//     public int addAccount(Accounts accounts) throws SQLException {
//         accountList.add(accounts);
//         return accountList.size();
//     }

//     public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
//         List<Accounts> sortedList = new ArrayList<>(accountList);
//         Collections.sort(sortedList);
//         return sortedList;
//     }

//     public void emptyArrayList() {
//         accountList = new ArrayList<>();
//     }

//     // public Accounts getAccountById(int accountId) {
//     //     for (Accounts a : accountList) {
//     //         if (a.getAccountId() == accountId)
//     //             return a;
//     //     }
//     //     return null;
//     // }
// }


package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Accounts;

@Service
public class AccountServiceImplArraylist {

    private final List<Accounts> accountsList;

    public AccountServiceImplArraylist() { 
        this.accountsList = new ArrayList<>();
    }

    public List<Accounts> getAllAccounts() {
        return new ArrayList<>(accountsList);
    }

    public int addAccount(Accounts accounts) {
        accountsList.add(accounts);
        return accountsList.size();
    }

    public List<Accounts> getAllAccountsSortedByBalance() {
        List<Accounts> sortedList = new ArrayList<>(accountsList);
        sortedList.sort(Comparator.comparingDouble(Accounts::getBalance));
        return sortedList;
    }

    public void emptyArrayList() {
        accountsList.clear();
    }

    // Optional:
    // public Accounts getAccountById(int accountId) {
    //     for (Accounts a : accountsList) if (a.getAccountId() == accountId) return a;
    //     return null;
    // }
}
