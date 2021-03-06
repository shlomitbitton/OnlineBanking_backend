package com.onlinebanking.ICINBank.repository;

import com.onlinebanking.ICINBank.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
    public User getUserByUserKey(long userKey);

}
