package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.repository.AccountRepository;
import com.onlinebanking.ICINBank.repository.TransactionRegisterRepository;
import com.onlinebanking.ICINBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionRegisterService {

    @Autowired
    private TransactionRegisterRepository transactionRegisterRepository;

    @Autowired
    private AccountRepository accountRepository;


    public Iterable<TransactionRegister> getAllTransactionsByAccount(long accountId){
        Iterable<TransactionRegister> listOfTransactions= accountRepository.findListOfTransactionsByAccountKey(accountId);
        return listOfTransactions;
    }

}
