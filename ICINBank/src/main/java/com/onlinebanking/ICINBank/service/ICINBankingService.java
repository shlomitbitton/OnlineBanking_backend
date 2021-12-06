package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.repository.AccountRepository;
import com.onlinebanking.ICINBank.repository.TransactionRegisterRepository;
import com.onlinebanking.ICINBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ICINBankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRegisterRepository transactionRegisterRepository;


    public Iterable<Account> getAllAccountsByUser(long user){
        User userO = userRepository.getUserByUserKey(user);
        return accountRepository.findAllByUser(userO);
    }

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

    public User getUserByUserKey(long userKey){
        return userRepository.getUserByUserKey(userKey);
    }

    public Iterable<User> getUserList(){
        return userRepository.findAll();
    }


    public Iterable<TransactionRegister> getAllTransactionsByAccountKey(long accountId){
        Iterable<TransactionRegister> listOfTransactions= accountRepository.findListOfTransactionsByAccountKey(accountId);
        return listOfTransactions;
    }

}
