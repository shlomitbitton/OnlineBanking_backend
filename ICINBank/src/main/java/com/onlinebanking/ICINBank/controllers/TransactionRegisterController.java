package com.onlinebanking.ICINBank.controllers;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.service.LoginService;
import com.onlinebanking.ICINBank.service.TransactionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TransactionRegisterController {

    @Autowired
    public TransactionRegisterService transactionRegisterService;

    @GetMapping(path="/allTransactions")
    public TransactionRegister transactionList(@RequestBody Account account, LocalDate date){
       // transactionRegisterService.getAllTransactionsByAccount(account.getAccountKey());
        return new TransactionRegister(account);
       // return "allTransactions.html";
    }
}
