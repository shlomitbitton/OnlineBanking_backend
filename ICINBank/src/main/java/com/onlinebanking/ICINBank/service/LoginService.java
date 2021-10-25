package com.onlinebanking.ICINBank.service;

import com.onlinebanking.ICINBank.model.User;
import com.onlinebanking.ICINBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Component
public class LoginService {

    @Autowired
    private UserRepository userRepository;


    public boolean isValidUser(String username, String password){
        if(!username.isEmpty() && !password.isEmpty()){
            if(userRepository.findByUsername(username) != null){
                if(Objects.equals(userRepository.findByUsername(username).getPassword(), password)){
                    return true;
                }
            }
        }
        return false;
    }


}
