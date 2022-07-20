package com.luizjhonata.jotabankapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Embeddable
@Table(name = "tb_account")
public class Account {

    @Getter @Setter @Column(name = "account_number")
    private String numberAccount; //An account need to have a numberAccount

    @Getter @Setter @Column(name = "account_agency")
    private String agency; //An account need to have an agency

    @Getter @Setter @Column(name = "account_balance")
    private Double balance; //An account have a balance and all balances starts from zero

    public Account(String numberAccount, String agency, Double balance) {
        this.numberAccount = numberAccount;
        this.agency = agency;
        this.balance = balance;
    }

    public Account(Account x) {
    }
}
