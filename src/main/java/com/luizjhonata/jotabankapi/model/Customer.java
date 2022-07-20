package com.luizjhonata.jotabankapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity @Table(name = "tb_customer")
public class Customer {

    @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //An account has an id

    @Getter @Setter @Column(name = "cpf")
    private String cpf; //An account need to have a cpf

    @Getter @Setter @Column(name = "customer_name")
    private String customerName; //An account need to have a customerName

    @Getter @Setter @Embedded
    private Account account; //A customer need to have an account

    public Customer(Integer id, String cpf, String customerName) {
        this.id = id;
        this.cpf = cpf;
        this.customerName = customerName;
    }


}
