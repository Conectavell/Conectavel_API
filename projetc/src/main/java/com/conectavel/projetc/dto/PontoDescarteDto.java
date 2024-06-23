package com.conectavel.projetc.dto;

import java.math.BigDecimal;

public class PontoDescarteDto {

    private String marcadorPonto;
    private BigDecimal LatitudePonto;
    private BigDecimal LongitudePonto;

    public String getMarcadorPonto() {
        return marcadorPonto;
    }

    public void setMarcadorPonto(String marcadorPonto) {
        this.marcadorPonto = marcadorPonto;
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
}
