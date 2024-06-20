package com.conectavel.projetc.controller;

import java.util.List;
import java.util.Optional;

import com.conectavel.projetc.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	
	@PostMapping("/salvarUsuario")
	public ResponseEntity<UsuarioDto> salvarUsuario(@RequestBody UsuarioDto usuarioDto)
	{
		UsuarioDto usuarioSalvoDto = usuarioService.salvarUsuario(usuarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvoDto);
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