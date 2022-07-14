package com.luizjhonata.jotabankapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "tb_movement")
public class Movement {

    @Id @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //A movement need to have an id

    @Getter @Setter @Column(length = 20)
    private String description; //A movement have a description

    @Getter @Setter @Column(name = "date_time")
    private LocalDateTime moment; //A movement have a moment

    @Getter @Setter @Column(name = "movement_value")
    private Double value; //A movement need to have a value different from zero

    @Enumerated(EnumType.STRING) @Getter @Setter @Column(name = "movement_type")
    private MovementType type; //A movement need to have a type

    @Getter @Setter @Column(name = "origin_account")
    private String originAccount; //A movement need to have a originAccount

    @Getter @Setter @Column(name = "destination_account")
    private String destinationAccount; //A destinationAccount is only used in transfer movements

    public Movement(Integer id, String description, LocalDateTime moment, Double value, MovementType type,
                    String originAccount, String destinationAccount) {
        this.id = id;
        this.description = description;
        this.moment = moment;
        this.value = value;
        this.type = type;
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
    }
}
