package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.dto.AccountDto;
import com.onlinebanking.ICINBank.enums.AccountType;
import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.repository.AccountRepository;
import com.onlinebanking.ICINBank.repository.TransactionRegisterRepository;
import com.onlinebanking.ICINBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public Iterable<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public Iterable<TransactionRegister> getAllTransactionsByAccountKey(long accountId){
        return accountRepository.findListOfTransactionsByAccountKey(accountId);
    }


    @Override
    public  List<AccountDto> findAllAccountsByUserKey(long userKey) {
        List<AccountDto> accountDtoList;
        List<Long> listOfAccounts = accountRepository.findAllAccountsByUserKey(userKey);
        accountDtoList = IntStream.range(1, listOfAccounts.size() + 1).mapToObj(i -> this.getDtoByAccountId((long) i)).collect(Collectors.toList());
        return accountDtoList;
    }

    @Transactional
    private  AccountDto getDtoByAccountId(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountType(account.get().getAccountType().getType());
        accountDto.setBalance(account.get().getBalance());
        return accountDto;
    }

    @Override
    public Iterable<TransactionRegister> transactionList(long accountId, LocalDate date) {
        return null;
    }
}

