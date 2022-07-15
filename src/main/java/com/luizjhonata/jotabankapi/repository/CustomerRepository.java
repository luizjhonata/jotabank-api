package com.luizjhonata.jotabankapi.repository;


import com.luizjhonata.jotabankapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByCpf(String cpf);


}
