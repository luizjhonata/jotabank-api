package com.luizjhonata.jotabankapi.controller;


import com.luizjhonata.jotabankapi.dto.CustomerDTO;
import com.luizjhonata.jotabankapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    //Get for list all customers
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<CustomerDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<CustomerDTO>> findById(@PathVariable Integer id) {
        List<CustomerDTO> list = service.findById(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<List<CustomerDTO>> findByCpf(@PathVariable String cpf) {
        List<CustomerDTO> list = service.findByCpf(cpf);
        return ResponseEntity.ok(list);
    }

    //Get for save a new costumer
    @PostMapping
    public ResponseEntity<CustomerDTO> insert(@RequestBody CustomerDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
