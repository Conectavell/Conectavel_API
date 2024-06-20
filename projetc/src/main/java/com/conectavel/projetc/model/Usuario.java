package com.conectavel.projetc.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tbUsuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(nullable = false, length = 30)
	private String nacionalidadeUsuario;

	@Column(nullable = false)
	private String tipoDePerfilUsuario;

	@Column(nullable = false, length = 60)
	private String nomeUsuario;

	@Column(nullable = false, length = 60)
	private String sobrenomeUsuario;

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

	@OneToOne(cascade = CascadeType.ALL) //@OneToOne: Define um relacionamento um para um entre Usuario e Endereco.
	@JoinColumn(name="idEndereco") //  @JoinColumn(name = "idEndereco"): Especifica que a coluna idEndereco na tabela Usuario será usada como chave estrangeira para associar o Usuario ao Endereco.
	@JsonManagedReference // evita loop em postman
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}

	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
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
