package com.onlinebanking.ICINBank.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TransactionRegisterDto {
    private double amount;
    private String transactionType;
    private LocalDate timestamp;
    private long fromAccount;
    private long toAccount;

}
