package com.luizjhonata.jotabankapi.repository;

import com.luizjhonata.jotabankapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
