package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.dto.AccountDto;
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
    public List<AccountDto> findAllAccountsByUserKey(long userKey);
    public Iterable<User> getUserList();
    public Iterable<Account> getAccountList();
    public boolean isValidUser(String username, String password);

    List<AccountDto> getUserAccountsList(long userKey);
}
