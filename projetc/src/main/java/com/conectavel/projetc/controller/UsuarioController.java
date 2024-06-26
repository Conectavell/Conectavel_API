package com.conectavel.projetc.controller;

import java.util.List;
import java.util.Optional;

import com.conectavel.projetc.dto.FiltrarDto;
import com.conectavel.projetc.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.service.UsuarioService;


@RestController
@RequestMapping("/API")
@CrossOrigin("http://localhost:5173")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("")
	public ResponseEntity<String> PaginaOi(){
		return ResponseEntity.status(HttpStatus.CREATED).body("Oi");
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

	@GetMapping("/filtarUsuario")
	public ResponseEntity<List<FiltrarDto>> filtrarUsuario(@RequestParam Long valorHabilidade){
		List<FiltrarDto> usuarios = usuarioService.filtrarPerfil(valorHabilidade);
		return ResponseEntity.ok(usuarios);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Long id)
	{
		usuarioService.deletarUsuario(id);
		return ResponseEntity.ok("Usuario deletado com sucesso!");
	}

	@GetMapping("/contarUsuarios")
	public long contarUsuarios() {
		return usuarioService.countUsuarios();
	}

	@GetMapping("/contarUsuarioFiltrado/{tipoPerfil}")
	public long contarUsuariosPorTipoDePerfil(@PathVariable Long tipoPerfil){
		return usuarioService.contarUsuariosPorTipoDePerfil(tipoPerfil);
	}

	@PutMapping("/{id}/atualizarEmail")
	public ResponseEntity<Void> atualizarEmail(@PathVariable Long id, @RequestParam String novoEmail){
		usuarioService.atualizarEmailUsuario(id, novoEmail);
		return ResponseEntity.noContent().build();
	}

    @PutMapping("/{id}/atualizarNome")
    public ResponseEntity<Void> atualizarNomeUsuario(@PathVariable Long id, @RequestParam String novoNome) {
        usuarioService.atualizarNomeUsuario(id, novoNome);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarSobrenome")
    public ResponseEntity<Void> atualizarSobrenomeUsuario(@PathVariable Long id, @RequestParam String novoSobrenome) {
        usuarioService.atualizarSobrenomeUsuario(id, novoSobrenome);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarSenha")
    public ResponseEntity<Void> atualizarSenhaUsuario(@PathVariable Long id, @RequestParam String novaSenha) {
        usuarioService.atualizarSenhaUsuario(id, novaSenha);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarExperiencia")
    public ResponseEntity<Void> atualizarExperienciaUsuario(@PathVariable Long id, @RequestParam String novaExperiencia) {
        usuarioService.atualizarExperienciaUsuario(id, novaExperiencia);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarFoto")
    public ResponseEntity<Void> atualizarFotoUsuario(@PathVariable Long id, @RequestParam String novaFoto) {
        usuarioService.atualizarFotoUsuario(id, novaFoto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarSobre")
    public ResponseEntity<Void> atualizarSobreUsuario(@PathVariable Long id, @RequestParam String novoSobre) {
        usuarioService.atualizarSobreUsuario(id, novoSobre);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/atualizarHabilidade")
    public ResponseEntity<Void> atualizarHabilidadeUsuario(@PathVariable Long id, @RequestParam String novaHabilidade) {
        usuarioService.atualizarHabilidadeUsuario(id, novaHabilidade);
        return ResponseEntity.noContent().build();
    }
}
