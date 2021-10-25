package com.onlinebanking.ICINBank.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum AccountType {

    CHECKING,
    SAVING;

    private String type;


    AccountType(String type) {
    this.type=type;
    }

    AccountType() {

    }
}
