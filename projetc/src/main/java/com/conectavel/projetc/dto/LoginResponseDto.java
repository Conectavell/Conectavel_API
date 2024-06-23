package com.conectavel.projetc.dto;

public class LoginResponseDto {
    private Long idUsuario;
    private Long idTipoPerfil;

    public LoginResponseDto(Long idUsuario, Long idTipoPerfil){
        this.idUsuario = idUsuario;
        this.idTipoPerfil = idTipoPerfil;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTipoPerfil() {
        return idTipoPerfil;
    }

    public void setIdTipoPerfil(Long idTipoPerfil) {
        this.idTipoPerfil = idTipoPerfil;
    }
}
