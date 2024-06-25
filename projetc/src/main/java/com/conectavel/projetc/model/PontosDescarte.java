package com.conectavel.projetc.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbPontosDescarte")
public class PontosDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPontosDescarte;

    @Column(nullable = false, precision = 20, scale = 10)
    private BigDecimal LatitudePonto;

    @Column(nullable = false, precision = 20, scale = 10)
    private BigDecimal LongitudePonto;

    @Column(nullable = false, length = 20)
    private String marcadorPonto;

    public Long getIdPontosDescarte() {
        return idPontosDescarte;
    }

    public void setIdPontosDescarte(Long idPontosDescarte) {
        this.idPontosDescarte = idPontosDescarte;
    }

    public BigDecimal getLatitudePonto() {
        return LatitudePonto;
    }

    public void setLatitudePonto(BigDecimal latitudePonto) {
        LatitudePonto = latitudePonto;
    }

    public BigDecimal getLongitudePonto() {
        return LongitudePonto;
    }

    public void setLongitudePonto(BigDecimal longitudePonto) {
        LongitudePonto = longitudePonto;
    }

    public String getMarcadorPonto() {
        return marcadorPonto;
    }

    public void setMarcadorPonto(String marcadorPonto) {
        this.marcadorPonto = marcadorPonto;
    }
}
