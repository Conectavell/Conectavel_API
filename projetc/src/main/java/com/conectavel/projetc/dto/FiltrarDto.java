package com.conectavel.projetc.dto;

public class FiltrarDto {
    private Long idUsuario;
    private String nomeUsuario;
    private String fotoPerfilPath;

    public FiltrarDto(Long idUsuario, String nomeUsuario, String fotoPerfilPath) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.fotoPerfilPath = fotoPerfilPath;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getFotoPerfilPath() {
        return fotoPerfilPath;
    }

    public void setFotoPerfilPath(String fotoPerfilPath) {
        this.fotoPerfilPath = fotoPerfilPath;
    }
}
