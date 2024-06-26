package com.conectavel.projetc.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbTipoPerfil")
public class TipoPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPerfil;

    @Column(nullable = false, length = 20)
    private String nomeTipoPerfil;

    @Column(nullable = false, length = 20)
    private String descricaoTipoPerfil;


    public TipoPerfil() {
    }

    public TipoPerfil(String nomeTipoPerfil, String descricaoTipoPerfil) {
        this.nomeTipoPerfil = nomeTipoPerfil;
        this.descricaoTipoPerfil = descricaoTipoPerfil;
    }


    public Long getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public void setIdTipoPerfil(Long idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }

    public String getNomeTipoPerfil() {
        return nomeTipoPerfil;
    }

    public void setNomeTipoPerfil(String nomeTipoPerfil) {
        this.nomeTipoPerfil = nomeTipoPerfil;
    }

    public String getDescricaoTipoPerfil() {
        return descricaoTipoPerfil;
    }

    public void setDescricaoTipoPerfil(String descricaoTipoPerfil) {
        this.descricaoTipoPerfil = descricaoTipoPerfil;
    }
}
