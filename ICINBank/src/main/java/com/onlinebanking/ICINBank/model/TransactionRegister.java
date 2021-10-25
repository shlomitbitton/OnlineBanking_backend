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

    @Column(name="FROM_ACCOUNT_ID")
    private long fromAccountId;

    @Column(name="TO_ACCOUNT_ID")
    private long toAccountId;

    @Column(name="TIMESTAMP")
    private LocalDate timestamp;

    @Column(name="TRANSACTION_TYPE")
    private TransactionType transactionType;

    public TransactionRegister(long fromAccountId, long toAccountId, LocalDate timestamp, TransactionType transactionType) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "TransactionRegister{" +
                "transactionRegisterKey=" + transactionRegisterKey +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", timestamp=" + timestamp +
                ", transactionType=" + transactionType +
                '}';
    }
}
