package com.onlinebanking.ICINBank.dto;

import com.onlinebanking.ICINBank.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDto {

    private String accountType;
    private int balance;

}
