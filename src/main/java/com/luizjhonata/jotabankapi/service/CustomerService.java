package com.luizjhonata.jotabankapi.service;

import com.luizjhonata.jotabankapi.dto.CustomerDTO;
import com.luizjhonata.jotabankapi.model.Customer;
import com.luizjhonata.jotabankapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<CustomerDTO> findAll(){
        List<Customer> list = repository.findAll();
        return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
    }

//    public CustomerDTO insert(CustomerDTO dto) {
//        Customer customer = new Customer (null, dto.getCpf(), dto.getCustomerName());
//        customer = repository.save(customer);
//        return new CustomerDTO(customer);
//    }
    
}
