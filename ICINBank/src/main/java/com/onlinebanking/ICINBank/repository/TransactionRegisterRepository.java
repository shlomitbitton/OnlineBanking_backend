package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.TransactionRegister;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRegisterRepository extends CrudRepository<TransactionRegister, Long> {

    @Transactional(readOnly=true)
    @Query(value= "SELECT tr.from_account, tr.to_account, tr.amount, tr.transaction_type, tr.timestamp  FROM transaction_register tr WHERE"
            + " tr.to_account =:toAccount or tr.to_account =:fromAccount",nativeQuery = true)
    List<Long> findListOfTransactionsByAccountKey(@Param("toAccount")long toAccount, @Param("fromAccount")long fromAccount);
}
