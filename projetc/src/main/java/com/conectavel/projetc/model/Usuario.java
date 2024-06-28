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

	@ManyToOne
	@JoinColumn(name="tipoPerfilId", nullable = false)
	@JsonManagedReference
	private TipoPerfil tipoPerfil;

	@Column(nullable = false, length = 60)
	private String nomeUsuario;

	@Column(nullable = false, length = 60)
	private String sobrenomeUsuario;

	@Column(nullable = false, length = 120, unique=true)
	private String emailUsuario;

	@Column(nullable = false, length = 12)
	private String senhaUsuario;

	@Column(nullable = false, length = 30, unique=true)
	private String cpfUsuario;

	@Column(nullable = false, length = 30, unique = true)
	private String celularUsuario;

	@Column(nullable = false)
	private Date dataNascimentoUsuario;

	@Column(nullable = false)
	private char sexoUsuario;

	@Column(nullable = true, length = 120)
	private String sobreUsuario;

	@Column(nullable = true, length = 120)
	private String experienciaUsuario;

	@Column(nullable = true, length = 255)
	private String fotoPerfilPath = "'./assets/fotosUsuarios/Profile.jpeg'";

	@OneToOne(cascade = CascadeType.ALL) //@OneToOne: Define um relacionamento um para um entre Usuario e Endereco.
	@JoinColumn(name="idEndereco") //  @JoinColumn(name = "idEndereco"): Especifica que a coluna idEndereco na tabela Usuario será usada como chave estrangeira para associar o Usuario ao Endereco.
	@JsonManagedReference // evita loop em postman
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Habilidades_Usuario", joinColumns = {@JoinColumn(name = "idUsuario")}, inverseJoinColumns = {@JoinColumn(name = "idHabilidade")})
	@JsonManagedReference
	private List<Habilidades> habilidades;

	public List<Habilidades> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}

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

	public Long getTipoPerfil() {
		return tipoPerfil.getIdTipoPerfil();
	}

	public void setTipoPerfil(TipoPerfil tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
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
