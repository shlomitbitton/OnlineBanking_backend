package com.onlinebanking.ICINBank.enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    WITHDRAW("withdraw"),
    TRANSFER("transfer"),
    DEPOSIT("deposit"),
    CHECK_ORDER("checkOrder");

    private final String type;

    TransactionType(String type) {
        this.type=type;
    }
}
