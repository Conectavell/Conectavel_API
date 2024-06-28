package com.conectavel.projetc.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbHabilidades")
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidade;

    @Column(nullable = false, length = 60)
    private String nomeHabilidade;

    @Column(nullable = false, length = 90)
    private String descricaoHabilidade;

    @ManyToMany(mappedBy = "habilidades")
    private List<Usuario> usuario;

    public Habilidades() {
    }

    public Habilidades(String nomeHabilidade, String descricaoHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
        this.descricaoHabilidade = descricaoHabilidade;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Long getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Long idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }

    public String getDescricaoHabilidade() {
        return descricaoHabilidade;
    }

    public void setDescricaoHabilidade(String descricaoHabilidade) {
        this.descricaoHabilidade = descricaoHabilidade;
    }
}
