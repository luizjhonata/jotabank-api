package com.luizjhonata.jotabankapi.service;

import com.luizjhonata.jotabankapi.dto.MovementDTO;
import com.luizjhonata.jotabankapi.model.Movement;
import com.luizjhonata.jotabankapi.model.MovementType;
import com.luizjhonata.jotabankapi.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovementService {

    @Autowired
    private MovementRepository repository;
//null, dto.getDescription(), dto.getMoment(), dto.getValue(),
//                dto.getType(), dto.getOriginAccount(), dto.getDestinationAccount()

    public MovementDTO insert(MovementDTO dto) {
        Movement movement = new Movement();

        Double value = dto.getValue();
        if(dto.getType() == MovementType.DEPOSIT) {
            movement.setDestinationAccount(null);
        } else if (dto.getType() == MovementType.PAYMENT) {
            value = value * -1;
            movement.setDestinationAccount(null);
        } else movement.setDestinationAccount(dto.getDestinationAccount());

        movement.setMoment(LocalDateTime.now());
        movement.setDescription(dto.getDescription());
        movement.setOriginAccount(dto.getOriginAccount());
        movement.setType(dto.getType());
        movement.setValue(value);

        movement = repository.save(movement);

        return new MovementDTO(movement);



    }


}
