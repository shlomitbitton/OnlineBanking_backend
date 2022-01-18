package com.onlinebanking.ICINBank.controllers;

import com.onlinebanking.ICINBank.dto.AccountDto;
import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.LoginRequest;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.service.ICINBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ICINBankingController {

    @Autowired
    public ICINBankingService iCINBankingService;



//    @GetMapping("/accounts")
//    public void getListOfAccount(@RequestBody long userKey){
//        User user = userService.getUserByUserKey(userKey);
//        accountService.getAllAccountsByUser(user.getUserKey());
//    }

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
    public Iterable<TransactionRegister> transactionList(@RequestBody long accountId, LocalDate date){
        return iCINBankingService.getAllTransactionsByAccountKey(accountId);
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
            //return iCINBankingService.findAllAccountsByUserKey(Long.parseLong(user));
            return iCINBankingService.getUserAccountsList(Long.parseLong(user));
        }catch(Exception e){
            System.out.println("trying to fetch accounts for user " + user+ " "+ e.getMessage());
        }
       return new ArrayList<>();
    }
}
