package com.luizjhonata.jotabankapi.controller;

import com.luizjhonata.jotabankapi.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "movements")
public class MovementController {

    @Autowired
    private MovementService service;


}
