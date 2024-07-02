package com.conectavel.projetc.repository;

import com.conectavel.projetc.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findById(Long id);
}
