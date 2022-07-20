package com.luizjhonata.jotabankapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor @Entity @Table(name = "tb_movement")
public class Movement {

    @Id @Getter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //A movement need to have an id

    @Getter @Setter @Column(length = 20)
    private String description; //A movement have a description

    @Getter @Setter
    private Instant moment; //A movement have a moment

    @Getter @Setter @Column(name = "movement_value")
    private Double value; //A movement need to have a value different from zero

    @Enumerated(EnumType.STRING) @Getter @Setter @Column(name = "movement_type")
    private MovementType type; //A movement need to have a type

    @Getter @Setter @Column(name = "origin_account")
    private String originCpf; //A originCpf is only used in transfer movements

    @Getter @Setter @Column(name = "destination_account")
    private String transferDestinationCpf; //A movement need to have a destinationCpf

    public Movement(Integer id, String description, Instant moment, Double value, MovementType type,
                    String originCpf, String transferDestinationCpf) {
        this.id = id;
        this.description = description;
        this.moment = moment;
        this.value = value;
        this.type = type;
        this.originCpf = originCpf;
        this.transferDestinationCpf = transferDestinationCpf;
    }
}
