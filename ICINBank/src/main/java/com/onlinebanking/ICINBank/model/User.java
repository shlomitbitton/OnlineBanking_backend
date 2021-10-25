package com.onlinebanking.ICINBank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="USER_KEY")
    private long userKey;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany
    private List<Account> accounts;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="USERNAME")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="PIN")
    private int pin;


    public User(String firstName, String lastName, List<Account> accounts, String email, String phone, String username, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = accounts;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userKey=" + userKey +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", pin=" + pin +
                '}';
    }
}
