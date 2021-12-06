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
    @JoinColumn(name="USER", nullable=false, updatable=false)
    private User user;

    @Column(name="BALANCE")
    private int balance;

    @OneToMany(mappedBy = "fromAccount")
    private List<TransactionRegister> listOfFromTransactions;

    @OneToMany(mappedBy = "toAccount")
    private List<TransactionRegister> listOfToTransactions;

    @Column(name="ACCOUNT_TYPE")
    private AccountType accountType;

    public Account() {
    }

    public Account(User accountHolderUser, int balance, AccountType accountType) {
       // this.accountHolderUser = accountHolderUser;
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
