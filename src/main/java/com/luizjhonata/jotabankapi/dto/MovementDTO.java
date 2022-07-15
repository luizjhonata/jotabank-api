package com.luizjhonata.jotabankapi.dto;

import com.luizjhonata.jotabankapi.model.Movement;
import com.luizjhonata.jotabankapi.model.MovementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
public class MovementDTO {

    @Getter @Setter
    private Integer id; //A movement need to have an id

    @Getter @Setter
    private String description; //A movement have a description

    @Getter @Setter
    private LocalDateTime moment; //A movement have a moment

    @Getter @Setter
    private Double value; //A movement need to have a value different from zero

    @Getter @Setter
    private MovementType type; //A movement need to have a type

    @Getter @Setter
    private String originAccount; //A movement need to have a originAccount

    @Getter @Setter
    private String destinationAccount; //A destinationAccount is only used in transfer movements

    public MovementDTO(Integer id, String description, LocalDateTime moment, Double value, MovementType type,
                    String originAccount, String destinationAccount) {
        this.id = id;
        this.description = description;
        this.moment = moment;
        this.value = value;
        this.type = type;
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }

    public MovementDTO(Movement model) {
        id = model.getId();
        description = model.getDescription();
        moment = getMoment();
        value = model.getValue();
        type = model.getType();
        originAccount = model.getOriginAccount();
        destinationAccount = model.getDestinationAccount();
    }
}
