package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    public Iterable<TransactionRegister> findListOfTransactionsByAccountKey(long accountKey);
}
