package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ICINBankingService {

    public Iterable<TransactionRegister> transactionList(@RequestBody long accountId, LocalDate date);
    public Iterable<TransactionRegister> getAllTransactionsByAccountKey(long accountId);
    public ArrayList<Account> findAllAccountsByUserKey(long userKey);
    public Iterable<User> getUserList();
    public boolean isValidUser(String username, String password);
}
