package com.conectavel.projetc.controller;

import java.util.List;
import java.util.Optional;

import com.conectavel.projetc.dto.UsuarioDto;
import com.conectavel.projetc.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.service.UsuarioService;


@RestController
@RequestMapping("/API")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	@PostMapping("/setUsuario")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDto usuarioDto)
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

		Endereco endereco = new Endereco();
		endereco.setLogradouro(usuarioDto.getEnderecoDto().getLogradouro());
		endereco.setBairro(usuarioDto.getEnderecoDto().getBairro());
		endereco.setComplemento(usuarioDto.getEnderecoDto().getComplemento());
		endereco.setUf(usuarioDto.getEnderecoDto().getUf());
		endereco.setNumero(usuarioDto.getEnderecoDto().getNumero());

		novoUsuario.setEndereco(endereco);
		endereco.setUsuario(novoUsuario);

		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@GetMapping("/getUsuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> usuarioServices(@PathVariable Long id, @RequestBody Usuario usuario){
		Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Long id)
	{
		usuarioService.deletarUsuario(id);
		return ResponseEntity.ok("Usuario deletado com sucesso!");
	}
	
}
