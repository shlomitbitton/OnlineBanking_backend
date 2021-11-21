package com.onlinebanking.ICINBank.controllers;

import com.onlinebanking.ICINBank.model.LoginRequest;
import com.onlinebanking.ICINBank.repository.UserRepository;
import com.onlinebanking.ICINBank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    public LoginService loginService;

    @PostMapping(path="/login")
    public void login(@RequestBody String username, String password, Model model){
          LoginRequest loginRequest = new LoginRequest();
          loginRequest.setPassword(password);
          loginRequest.setUsername(username);
        if(loginService.isValidUser(username, password)){
            model.addAttribute(loginRequest);
        }
       // return "login.html";
    }
}
