package com.conectavel.projetc.service;

import com.conectavel.projetc.dto.EnderecoDto;
import com.conectavel.projetc.dto.UsuarioDto;
import com.conectavel.projetc.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public UsuarioDto salvarUsuario(UsuarioDto usuarioDto)
	{
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNomeUsuario(usuarioDto.getNomeUsuario());
		novoUsuario.setSobrenomeUsuario(usuarioDto.getSobrenomeUsuario());
		novoUsuario.setEmailUsuario(usuarioDto.getEmailUsuario());
		novoUsuario.setSenhaUsuario(usuarioDto.getSenhaUsuario());
		novoUsuario.setCpfUsuario(usuarioDto.getCpfUsuario());
		novoUsuario.setDataNascimentoUsuario(usuarioDto.getDataNascimentoUsuario());
		novoUsuario.setNacionalidadeUsuario(usuarioDto.getNacionalidadeUsuario());
		novoUsuario.setSexoUsuario(usuarioDto.getSexoUsuario());
		novoUsuario.setTipoDePerfilUsuario(usuarioDto.getTipoDePerfilUsuario());
		novoUsuario.setSobreUsuario(usuarioDto.getSobreUsuario());
		novoUsuario.setExperienciaUsuario(usuarioDto.getExperienciaUsuario());

		if (usuarioDto.getEnderecoDto() != null) {
			Endereco endereco = new Endereco();
			endereco.setLogradouro(usuarioDto.getEnderecoDto().getLogradouro());
			endereco.setBairro(usuarioDto.getEnderecoDto().getBairro());
			endereco.setComplemento(usuarioDto.getEnderecoDto().getComplemento());
			endereco.setUf(usuarioDto.getEnderecoDto().getUf());
			endereco.setNumero(usuarioDto.getEnderecoDto().getNumero());
			endereco.setCep(usuarioDto.getEnderecoDto().getCep());

			novoUsuario.setEndereco(endereco);
			endereco.setUsuario(novoUsuario);
		}

		Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

		UsuarioDto usuarioSalvoDto = new UsuarioDto();
		usuarioSalvoDto.setNomeUsuario(usuarioSalvo.getNomeUsuario());
		usuarioSalvoDto.setSobrenomeUsuario(usuarioSalvo.getSobrenomeUsuario());
		usuarioSalvoDto.setEmailUsuario(usuarioSalvo.getEmailUsuario());
		usuarioSalvoDto.setSenhaUsuario(usuarioSalvo.getSenhaUsuario());
		usuarioSalvoDto.setCpfUsuario(usuarioSalvo.getCpfUsuario());
		usuarioSalvoDto.setDataNascimentoUsuario(usuarioSalvo.getDataNascimentoUsuario());
		usuarioSalvoDto.setNacionalidadeUsuario(usuarioSalvo.getNacionalidadeUsuario());
		usuarioSalvoDto.setSexoUsuario(usuarioSalvo.getSexoUsuario());
		usuarioSalvoDto.setTipoDePerfilUsuario(usuarioSalvo.getTipoDePerfilUsuario());
		usuarioSalvoDto.setSobreUsuario(usuarioDto.getSobreUsuario());
		usuarioSalvoDto.setExperienciaUsuario(usuarioDto.getExperienciaUsuario());

		if (usuarioSalvo.getEndereco() != null) {
			EnderecoDto enderecoDto = new EnderecoDto();
			enderecoDto.setLogradouro(usuarioSalvo.getEndereco().getLogradouro());
			enderecoDto.setBairro(usuarioSalvo.getEndereco().getBairro());
			enderecoDto.setComplemento(usuarioSalvo.getEndereco().getComplemento());
			enderecoDto.setUf(usuarioSalvo.getEndereco().getUf());
			enderecoDto.setNumero(usuarioSalvo.getEndereco().getNumero());
			enderecoDto.setCep(usuarioSalvo.getEndereco().getCep());
			usuarioSalvoDto.setEnderecoDto(enderecoDto);
		}

		return usuarioSalvoDto;
	}

	public Long getIdByEmailAndSenha(String email, String senha){
		return usuarioRepository.findIdByEmailAndSenha(email, senha);
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
		if(usuarioExistente.isPresent()) {
			Usuario usuario = usuarioExistente.get();
			usuario.setNomeUsuario(usuarioAtualizado.getNomeUsuario());
			usuario.setEmailUsuario(usuarioAtualizado.getEmailUsuario());
			usuario.setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
			return usuarioRepository.save(usuario);
		}else {
			throw new RuntimeException("Usuario não encontrado...");
		}
		
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	//Método responsável por salvar cadastro;
	public ResponseEntity<Usuario> salvarUsuario1(@RequestBody Usuario usuario)
	{
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(novoUsuario);
	}
	
	//Método responsável por puxar cadastros;
	public ResponseEntity<List<Usuario>> fetchAllUsuarios()
	{
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	//Método responsável por puxar um único cadastro pelo ID;
	public ResponseEntity<Optional<Usuario>>
	fetchUsuarioById(Long id)
	{
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Método responsável por atualizar um único cadastro;
	public ResponseEntity<Usuario> atualizarUsuario1(Long id, Usuario usuarioAtualizado)
	{
		if(id == null)
		{
			throw new IllegalArgumentException("id não pode ser nulo!");
		}
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundException(String.valueOf(id)));
		usuarioExistente.setNomeUsuario(usuarioAtualizado.getNomeUsuario());
		usuarioExistente.setEmailUsuario(usuarioAtualizado.getEmailUsuario());
		usuarioExistente.setSenhaUsuario(usuarioAtualizado.getSenhaUsuario());
		Usuario savedEntity = usuarioRepository.save(usuarioExistente);
		return ResponseEntity.ok(savedEntity);
	}
	
	public ResponseEntity<String> deletarUsuario1(Long id)
	{
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok("Usuario removido com sucesso...");
	}
}
