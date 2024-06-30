package com.conectavel.projetc.dto;

import com.conectavel.projetc.model.TipoPerfil;
import jakarta.persistence.Column;

import java.sql.Date;
import java.util.List;

public class UsuarioDto {

    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String emailUsuario;
    private String celularUsuario;
    private String senhaUsuario;
    private String cpfUsuario;
    private Date dataNascimentoUsuario;
    private char sexoUsuario;
    private String nacionalidadeUsuario;
    private Long tipoDePerfilUsuario;
    private String sobreUsuario;
    private String experienciaUsuario;
    private EnderecoDto enderecoDto;
    private String fotoPerfilPath;
    private List<Long> habilidades;

    public List<Long> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Long> habilidades) {
        this.habilidades = habilidades;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getCelularUsuario() {
        return celularUsuario;
    }

    public void setCelularUsuario(String celularUsuario) {
        this.celularUsuario = celularUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Date getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(Date dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public char getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(char sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getNacionalidadeUsuario() {
        return nacionalidadeUsuario;
    }

    public void setNacionalidadeUsuario(String nacionalidadeUsuario) {
        this.nacionalidadeUsuario = nacionalidadeUsuario;
    }

    public Long getTipoDePerfilUsuario() {
        return tipoDePerfilUsuario;
    }

    public void setTipoDePerfilUsuario(Long tipoDePerfilUsuario) {
        this.tipoDePerfilUsuario = tipoDePerfilUsuario;
    }

    public EnderecoDto getEnderecoDto() {
        return enderecoDto;
    }

    public void setEnderecoDto(EnderecoDto enderecoDto) {
        this.enderecoDto = enderecoDto;
    }

    public String getSobreUsuario() {
        return sobreUsuario;
    }

    public void setSobreUsuario(String sobreUsuario) {
        this.sobreUsuario = sobreUsuario;
    }

    public String getExperienciaUsuario() {
        return experienciaUsuario;
    }

    public void setExperienciaUsuario(String experienciaUsuario) {
        this.experienciaUsuario = experienciaUsuario;
    }

    public String getFotoPerfilPath() {
        return fotoPerfilPath;
    }

    public void setFotoPerfilPath(String fotoPerfilPath) {
        this.fotoPerfilPath = fotoPerfilPath;
    }
}
