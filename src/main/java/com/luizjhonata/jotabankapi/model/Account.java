package com.luizjhonata.jotabankapi.model;

public class Account {

    private Integer id; //An account has an id;
    private Integer numberAccount; //An account need to have a numberAccount
    private Integer agency; //An account need to have an agency
    private Double balance; //An account have a balance and all balances starts from zero

    private Customer customer;   //One account need to have a customer

}
