package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.TransactionRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    public Iterable<TransactionRegister> findListOfTransactionsByAccountKey(long accountKey);

    @Transactional(readOnly=true)
    @Query(value= "SELECT ac.account_key, ac.account_type, ac.balance  FROM account ac WHERE"
           + " ac.user_key =:userKey",nativeQuery = true)
    List<Long> findAllAccountsByUserKey(@Param("userKey")long userKey);
}
