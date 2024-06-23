package com.conectavel.projetc.repository;

import com.conectavel.projetc.model.PontosDescarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PontosDescarteRepository extends JpaRepository<PontosDescarte, Long> {


    @Query("SELECT p.LatitudePonto, p.LongitudePonto, p.marcadorPonto FROM PontosDescarte p")
    List<PontosDescarte> mostrarPontos();
}
