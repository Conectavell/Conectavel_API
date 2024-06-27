package com.conectavel.projetc.service;

import com.conectavel.projetc.repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService {
    private final HabilidadesRepository habilidadesRepository;

    @Autowired
    public HabilidadesService(HabilidadesRepository habilidadesRepository){
        this.habilidadesRepository = habilidadesRepository;
    }


}
