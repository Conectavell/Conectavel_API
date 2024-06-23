package com.conectavel.projetc.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tbPontosDescarte")
public class PontosDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPontosDescarte;

    
}
