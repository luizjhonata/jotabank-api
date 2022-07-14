package com.luizjhonata.jotabankapi.repository;

import com.luizjhonata.jotabankapi.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

}
