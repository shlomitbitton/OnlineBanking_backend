package com.onlinebanking.ICINBank.controllers;

import com.onlinebanking.ICINBank.dto.AccountDto;
import com.onlinebanking.ICINBank.dto.TransactionRegisterDto;
import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.LoginRequest;
import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.service.ICINBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ICINBankingController {

    @Autowired
    public ICINBankingService iCINBankingService;

    

    @PostMapping(path="/login")
    public void login(@RequestBody String username, String password, Model model){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(password);
        loginRequest.setUsername(username);
        if(iCINBankingService.isValidUser(username, password)){
            model.addAttribute(loginRequest);
        }
    }

    @GetMapping(path="/allTransactions")
    public List<TransactionRegisterDto> transactionList(@Param("toAccount")long toAccount, @Param("fromAccount")long fromAccount){
        try{
            return iCINBankingService.getAllTransactionsByAccountKey(toAccount, fromAccount);
        }catch(Exception e){
            System.out.println("Unable to fetch transactions for account " + toAccount+ "and " + " "+ fromAccount + " "+e.getMessage());
        }
        return new ArrayList<>();
    }

    @GetMapping(path="/allUsers")
    public Iterable<User> userList(){
        return iCINBankingService.getUserList();
    }

    @GetMapping(path="/allAccounts")
    public Iterable<Account> accountList(){
        return iCINBankingService.getAccountList();
    }

    @GetMapping(path="/users/{userKey}/accounts")
    @ResponseBody
    public List<AccountDto> getUserAccountsList(@PathVariable("userKey") String user){
        try{
            return iCINBankingService.getUserAccountsList(Long.parseLong(user));
        }catch(Exception e){
            System.out.println("Unable to fetch accounts for user " + user+ " "+ e.getMessage());
        }
       return new ArrayList<>();
    }
}
