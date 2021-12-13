package com.onlinebanking.ICINBank.model;

import com.onlinebanking.ICINBank.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TransactionRegister {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TRANSACTION_REGISTER_KEY")
    private long transactionRegisterKey;


    @ManyToOne
//    @JoinColumn(name="FROM_ACCOUNT", nullable=false, updatable=false)
    private Account fromAccount;

    @ManyToOne
//    @JoinColumn(name="TO_ACCOUNT", nullable=false, updatable=false)
    private Account toAccount;

    @Column(name="TIMESTAMP")
    private LocalDate timestamp;

    @Column(name="TRANSACTION_TYPE")
    private TransactionType transactionType;

    public TransactionRegister(Account fromAccount, Account toAccount, LocalDate timestamp, TransactionType transactionType) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
    }
    public TransactionRegister(){

    }

    public TransactionRegister(Account fromAccount){

        //this.fromAccountKey = fromAccount;
    }

    @Override
    public String toString() {
        return "TransactionRegister{" +
                "transactionRegisterKey=" + transactionRegisterKey +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", timestamp=" + timestamp +
                ", transactionType=" + transactionType +
                '}';
    }
}
