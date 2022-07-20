package com.luizjhonata.jotabankapi.controller;

import com.luizjhonata.jotabankapi.dto.MovementDTO;
import com.luizjhonata.jotabankapi.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "movements")
public class MovementController {

    @Autowired
    private MovementService service;

    @GetMapping
    public ResponseEntity<List<MovementDTO>> findAll() {
        List<MovementDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Save a new movement
    @PostMapping
    public ResponseEntity<MovementDTO> insert(@RequestBody MovementDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
