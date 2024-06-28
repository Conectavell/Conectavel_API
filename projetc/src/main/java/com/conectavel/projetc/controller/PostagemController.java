package com.conectavel.projetc.controller;

import com.conectavel.projetc.dto.PostagemDto;
import com.conectavel.projetc.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API")
@CrossOrigin("http://localhost:5173")
public class PostagemController {
    private final PostagemService postagemService;

    @Autowired
    public PostagemController(PostagemService postagemService){
        this.postagemService = postagemService;
    }

    @PostMapping("/addPost")
    public ResponseEntity<PostagemDto> salvarPostagem(@RequestBody PostagemDto postagemDto){
        PostagemDto postagemDtoSalvo = postagemService.salvarPostagem(postagemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemDtoSalvo);
    }

    @DeleteMapping("/dltPost/{id}")
    public ResponseEntity<String> deletarPostagem(@PathVariable Long id){
        postagemService.deletarPorId(id);
        return ResponseEntity.ok("Postagem removida com sucesso!");
    }

}
