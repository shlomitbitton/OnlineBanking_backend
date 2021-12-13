package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import com.onlinebanking.ICINBank.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    public Iterable<TransactionRegister> findListOfTransactionsByAccountKey(long accountKey);
    @Query(value= "SELECT * FROM Account WHERE"
           + " user_key =:userKey",nativeQuery = true)
           // "in (select user_key from User where user_key=:userKey)",nativeQuery = true)
    ArrayList<Account> findAllAccountsByUserKey(@Param("userKey")long userKey);
}
