package com.luizjhonata.jotabankapi.dto;

import com.luizjhonata.jotabankapi.model.Account;
import com.luizjhonata.jotabankapi.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CustomerDTO {

    @Getter @Setter
    private Integer id; //An account has an id

    @Getter @Setter
    private String cpf; //An account need to have a cpf

    @Getter @Setter
    private String customerName; //An account need to have a customerName

    @Getter @Setter
    private Account account; //A customer need to have an account


    public CustomerDTO(Integer id, String cpf, String customerName, Account account) {
        this.id = id;
        this.cpf = cpf;
        this.customerName = customerName;
        this.account = account;
    }

    public CustomerDTO(Customer model) {
            id = model.getId();
            cpf = model.getCpf();
            customerName = model.getCustomerName();
            account = model.getAccount();
        }
}
