package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.Account;
import com.onlinebanking.ICINBank.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
    public User getUserByUserKey(long userKey);
//    public List<Account> findAccounts();

}
