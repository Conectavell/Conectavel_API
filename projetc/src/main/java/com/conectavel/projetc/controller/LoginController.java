package com.conectavel.projetc.controller;


import com.conectavel.projetc.dto.LoginRequest;
import com.conectavel.projetc.dto.LoginResponseDto;
import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Usuario usuario = usuarioRepository.findByEmailUsuarioAndSenhaUsuario(
                loginRequest.getEmail(), loginRequest.getSenha()
        );
        if(usuario != null){
            LoginResponseDto responseDto = new LoginResponseDto(usuario.getIdUsuario(), usuario.getTipoPerfil());
            return ResponseEntity.ok(responseDto);
        }else{
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }
}
