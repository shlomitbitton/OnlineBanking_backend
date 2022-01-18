package com.onlinebanking.ICINBank.dto;

import com.onlinebanking.ICINBank.enums.AccountType;
import lombok.Setter;

@Setter
public class AccountDto {

    private String accountType;
    private int balance;

}
