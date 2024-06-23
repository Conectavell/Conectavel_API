package com.conectavel.projetc.controller;


import com.conectavel.projetc.dto.PontoDescarteDto;
import com.conectavel.projetc.model.PontosDescarte;
import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.service.PontosService;
import com.conectavel.projetc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
@CrossOrigin("http://localhost:5173")
public class PontosController {
    private final PontosService pontosService;

    @Autowired
    public PontosController(PontosService pontosService){
        this.pontosService = pontosService;
    }

    @PostMapping("/SalvarPonto")
    public ResponseEntity<PontoDescarteDto> salvarPonto(@RequestBody PontoDescarteDto pontoDescarteDto){
        PontoDescarteDto pontoSalvoDto = pontosService.salvarPontoDeDescarte(pontoDescarteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pontoSalvoDto);
    }

    @GetMapping("/pontosDescarte")
    public List<PontosDescarte> getAllPontosDescarte() {
        return pontosService.getAllPontosDescarte();
    }
}
