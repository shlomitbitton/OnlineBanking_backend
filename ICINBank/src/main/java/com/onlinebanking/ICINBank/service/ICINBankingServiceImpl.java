package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.repository.AccountRepository;
import com.onlinebanking.ICINBank.repository.TransactionRegisterRepository;
import com.onlinebanking.ICINBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ICINBankingServiceImpl implements ICINBankingService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRegisterRepository transactionRegisterRepository;


    @Override
    public boolean isValidUser(String username, String password){
        if(!username.isEmpty() && !password.isEmpty()){
            if(userRepository.findByUsername(username) != null){
                if(Objects.equals(userRepository.findByUsername(username).getPassword(), password)){
                    return true;
                }
            }
        }
        return false;
    }

    private User getUserByUserKey(long userKey){
        return userRepository.getUserByUserKey(userKey);
    }

    @Override
    public Iterable<User> getUserList(){
        return userRepository.findAll();
    }

    @Override
    public Iterable<TransactionRegister> getAllTransactionsByAccountKey(long accountId){
        Iterable<TransactionRegister> listOfTransactions= accountRepository.findListOfTransactionsByAccountKey(accountId);
        return listOfTransactions;
    }

    @Override
    public ArrayList<Account> findAllAccountsByUserKey(long userKey) {
        return accountRepository.findAllAccountsByUserKey(userKey);
    }

    @Override
    public Iterable<TransactionRegister> transactionList(long accountId, LocalDate date) {
        return null;
    }
}

