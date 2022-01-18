package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.dto.AccountDto;
import com.onlinebanking.ICINBank.dto.TransactionRegisterDto;
import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface ICINBankingService {

    public Iterable<TransactionRegister> transactionList(@RequestBody long accountId, LocalDate date);
    public List<TransactionRegisterDto> getAllTransactionsByAccountKey(long toAccount, long fromAccount);
    public List<AccountDto> findAllAccountsByUserKey(long userKey);
    public Iterable<User> getUserList();
    public Iterable<Account> getAccountList();
    public boolean isValidUser(String username, String password);

    List<AccountDto> getUserAccountsList(long userKey);
}
