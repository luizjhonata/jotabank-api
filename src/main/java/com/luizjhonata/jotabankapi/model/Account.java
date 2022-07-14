package com.luizjhonata.jotabankapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Random;

@NoArgsConstructor
@Embeddable
@Table(name = "tb_account")
public class Account {

    private static final String DEFAULT_AGENCY = "0001";
    private static final Double DEFAULT_BALANCE = Double.valueOf(0);

    @Getter @Setter @Column(name = "account_number")
    private StringBuilder numberAccount; //An account need to have a numberAccount

    @Getter @Setter @Column(name = "account_agency")
    private Integer agency; //An account need to have an agency

    @Getter @Column(name = "account_balance")
    private Double balance; //An account have a balance and all balances starts from zero

    //Method to generate a random number among 0 and 9 in string format
    public String randomNumberString(){
        Random random = new Random();
        String randomNumber = Integer.toString(random.nextInt(9));
        return randomNumber;
    }

    //Method to generate a random number account, type StringBuilder, with 6 digits
    public StringBuilder randomAccount(){
        StringBuilder AccountNumber = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            AccountNumber.append(randomNumberString());
        }
        return AccountNumber;
    }

    public Account(StringBuilder numberAccount, String agency, Double balance) {
        this.numberAccount = randomAccount(); //if running some error, change for String.valueOf(randomAccount())
        this.agency = Integer.valueOf(Account.DEFAULT_AGENCY);
        this.balance = balance;
    }
}
