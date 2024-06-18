package com.conectavel.projetc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBendereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	
	@Column(nullable = false, length = 30)
	private String logradouro;
	
	@Column(nullable = false, length = 30)
	private String bairro;
	
	@Column(nullable = false, length = 30)
	private String complemento;
	
	@Column(nullable = false, length = 30)
	private String numero;
	
	@Column(nullable = false, length = 2)
	private String uf;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
