package com.conectavel.projetc.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TBusuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(nullable = false, length = 30)
	private String nacionalidadeUsuario;
	
	@Column(nullable = false)
	private String tipoDePerfilUsuario;
	
	@Column(nullable = false, length = 120)
	private String nomeUsuario;
	
	@Column(nullable = false, length = 120)
	private String emailUsuario;
	
	@Column(nullable = false, length = 12)
	private String senhaUsuario;
	
	@Column(nullable = false, length = 30)
	private String cpfUsuario;
	
	@Column(nullable = false)
	private Date dataNascimentoUsuario;

	@Column(nullable = false)
	private char sexoUsuario;
	
	@OneToMany
	@JoinColumn(name="idUsuario")
	private List<Endereco> endereco;

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
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

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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

	public String getTipoDePerfilUsuario() {
		return tipoDePerfilUsuario;
	}

	public void setTipoDePerfilUsuario(String tipoDePerfilUsuario) {
		this.tipoDePerfilUsuario = tipoDePerfilUsuario;
	}
	
	
	
	
}
