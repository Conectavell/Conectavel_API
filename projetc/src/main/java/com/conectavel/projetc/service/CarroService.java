package com.conectavel.projetc.service;

import com.conectavel.projetc.model.Carro;
import com.conectavel.projetc.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    public Optional<Carro> getCarroById(Long id){
        return carroRepository.findById(id);
    }

}
