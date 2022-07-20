package com.luizjhonata.jotabankapi.service;

import com.luizjhonata.jotabankapi.dto.MovementDTO;
import com.luizjhonata.jotabankapi.model.Customer;
import com.luizjhonata.jotabankapi.model.Movement;
import com.luizjhonata.jotabankapi.model.MovementType;
import com.luizjhonata.jotabankapi.repository.CustomerRepository;
import com.luizjhonata.jotabankapi.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovementService {

    @Autowired
    private MovementRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<MovementDTO> findAll(){
        List<Movement> list = repository.findAll();
        return list.stream().map(MovementDTO::new).collect(Collectors.toList());
    }

    public MovementDTO insert(MovementDTO dto) {
        Movement movement = new Movement();

        Double value = dto.getValue();
        if(dto.getType() == MovementType.DEPOSIT) {
            movement.setTransferDestinationCpf(null);
        } else if (dto.getType() == MovementType.PAYMENT) {
            value = value * -1;
            movement.setTransferDestinationCpf(null);
        } else movement.setTransferDestinationCpf(dto.getTransferDestinationCpf());
                movement.setOriginCpf(dto.getOriginCpf());
                String CpfDestination = dto.getTransferDestinationCpf();


        movement.setMoment(Instant.now());
        movement.setType(dto.getType());
        movement.setValue(value);
        movement.setDescription(dto.getDescription());

        String CpfOrigin = dto.getOriginCpf();

        Customer customerOrigin = customerRepository.findByCpf(CpfOrigin);

        if(dto.getType() == MovementType.DEPOSIT || dto.getType() == MovementType.PAYMENT)
            customerOrigin.getAccount().setBalance(customerOrigin.getAccount().getBalance() + value);
        else {
            Customer customerDestination = customerRepository.findByCpf(CpfDestination);
            customerOrigin.getAccount().setBalance(customerOrigin.getAccount().getBalance() - value);
            customerDestination.getAccount().setBalance(customerDestination.getAccount().getBalance() + value);
        }

        movement = repository.save(movement);
        return new MovementDTO(movement);

    }
}
