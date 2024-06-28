package com.conectavel.projetc.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbPostagens")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostagem;

    @Column(nullable = false, length = 255)
    private String fotoPostagem;

    @Column(nullable = false, length = 60)
    private String textoPostagem;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    public Postagem(){

    }

    public Postagem(String fotoPostagem, String textoPostagem){
        this.fotoPostagem = fotoPostagem;
        this.textoPostagem = textoPostagem;
    }


    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getFotoPostagem() {
        return fotoPostagem;
    }

    public void setFotoPostagem(String fotoPostagem) {
        this.fotoPostagem = fotoPostagem;
    }

    public String getTextoPostagem() {
        return textoPostagem;
    }

    public void setTextoPostagem(String textoPostagem) {
        this.textoPostagem = textoPostagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
