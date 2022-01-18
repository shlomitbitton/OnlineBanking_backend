package com.onlinebanking.ICINBank.enums;

import lombok.Getter;

@Getter
public enum AccountType {

    CHECKING("checking"),
    SAVING("saving");

    private final String type;


    AccountType(String type) {
    this.type=type;
    }
}
