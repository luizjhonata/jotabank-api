package com.luizjhonata.jotabankapi.service;

import com.luizjhonata.jotabankapi.dto.CustomerDTO;
import com.luizjhonata.jotabankapi.model.Account;
import com.luizjhonata.jotabankapi.model.Customer;
import com.luizjhonata.jotabankapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    //Method to list all customers
    public List<CustomerDTO> findAll(){
        List<Customer> list = repository.findAll();
        return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
    }

    public List<CustomerDTO> findById(Integer id) {
        Optional<Customer> list = repository.findById(id);
        return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
    }

    public List<CustomerDTO> findByCpf(String cpf) {
        List<Customer> list = repository.findByCpf(cpf);
        return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
    }

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

    //Method to save new costumer in the database
    @Transactional
    public CustomerDTO insert(CustomerDTO dto) {
        Customer customer = new Customer (null, dto.getCpf(), dto.getCustomerName());

        Account account = new Account();
        account.setBalance(0.0);
        account.setAgency("0001");
        account.setNumberAccount(String.valueOf(randomAccount()));

        customer.setAccount(account);

        customer = repository.save(customer);

        return new CustomerDTO(customer);
    }

}
