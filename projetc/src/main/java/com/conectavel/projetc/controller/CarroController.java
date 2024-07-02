package com.conectavel.projetc.controller;

import com.conectavel.projetc.model.Carro;
import com.conectavel.projetc.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Carros")
public class CarroController {
    private CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping("/QuantidadeCarros/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id){
        Optional<Carro> carro = carroService.getCarroById(id);
        return carro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
