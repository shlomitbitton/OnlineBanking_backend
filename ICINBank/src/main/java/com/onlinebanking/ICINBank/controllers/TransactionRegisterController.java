package com.onlinebanking.ICINBank.controllers;

import com.onlinebanking.ICINBank.service.LoginService;
import com.onlinebanking.ICINBank.service.TransactionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller
public class TransactionRegisterController {

    @Autowired
    public TransactionRegisterService transactionRegisterService;

    @PostMapping(path="/allTransactions")
    public String transactionList(@RequestBody long account, LocalDate date){
        transactionRegisterService.getAllTransactionsByAccount(account);
        return "allTransactions.html";
    }
}
