package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.TransactionRegister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRegisterRepository extends CrudRepository<TransactionRegister, Long> {
}
