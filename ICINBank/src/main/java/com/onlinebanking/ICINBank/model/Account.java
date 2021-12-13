package com.onlinebanking.ICINBank.model;

import com.onlinebanking.ICINBank.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ACCOUNT_KEY")
    private long accountKey;

    @ManyToOne
    private User user;

    @Column(name="BALANCE")
    private int balance;

    @OneToMany
    @JoinColumn(name="fromAccount")
    private List<TransactionRegister> listOfFromTransactions;

    @OneToMany
    @JoinColumn(name="toAccount")
    private List<TransactionRegister> listOfToTransactions;

    @Column(name="ACCOUNT_TYPE")
    private AccountType accountType;

    public Account() {
    }

    public Account(User accountHolderUser, int balance, AccountType accountType) {
        this.user = accountHolderUser;
        this.balance = balance;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountKey=" + accountKey +
              //  ", accountHolderUser=" + accountHolderUser +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
