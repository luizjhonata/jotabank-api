package com.luizjhonata.jotabankapi.dto;

import com.luizjhonata.jotabankapi.model.Movement;
import com.luizjhonata.jotabankapi.model.MovementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;


@NoArgsConstructor
public class MovementDTO {

    @Getter @Setter
    private Integer id; //A movement need to have an id

    @Getter @Setter
    private String description; //A movement have a description

    @Getter @Setter
    private Instant moment; //A movement have a moment

    @Getter @Setter
    private Double value; //A movement need to have a value different from zero

    @Getter @Setter
    private MovementType type; //A movement need to have a type

    @Getter @Setter
    private String originCpf; //A movement need to have a originAccount

    @Getter @Setter
    private String transferDestinationCpf; //A destinationAccount is only used in transfer movements

    public MovementDTO(Integer id, String description, Instant moment, Double value, MovementType type,
                       String originCpf, String transferDestinationCpf) {
        this.id = id;
        this.description = description;
        this.moment = moment;
        this.value = value;
        this.type = type;
        this.originCpf = originCpf;
        this.transferDestinationCpf = transferDestinationCpf;
    }

    public MovementDTO(Movement model) {
        id = model.getId();
        description = model.getDescription();
        moment = model.getMoment();
        value = model.getValue();
        type = model.getType();
        originCpf = model.getOriginCpf();
        transferDestinationCpf = model.getTransferDestinationCpf();
    }
}
