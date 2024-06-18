package com.conectavel.projetc.service;

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
	
	public Usuario salvarUsuario(Usuario usuario)
	{
		return usuarioRepository.save(usuario);
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
