package com.luizjhonata.jotabankapi.model;

import java.time.Instant;


public class Movement {

    private Integer id; //A movement need to have an id
    private String description; //A movement have a description
    private Instant moment; //A movement have a moment
    private Double value; //A movement need to have a value different from zero

    private MovementType type; //A movement need to have a type

    private Account originAccount; //A movement need to have a originAccount

    private Account destinationAccount; //A destinationAccount is optional for a movement, when destinationAccount
    // not apply null need to be a default value;

}
