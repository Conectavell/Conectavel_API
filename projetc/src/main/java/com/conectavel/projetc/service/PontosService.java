package com.conectavel.projetc.service;

import com.conectavel.projetc.dto.PontoDescarteDto;
import com.conectavel.projetc.model.PontosDescarte;
import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.repository.PontosDescarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontosService {
    private final PontosDescarteRepository pontosDescarteRepository;

    @Autowired
    public PontosService(PontosDescarteRepository pontosDescarteRepository){
        this.pontosDescarteRepository = pontosDescarteRepository;
    }

    public List<PontosDescarte> getAllPontosDescarte(){
        return pontosDescarteRepository.findAll();
    }

    public PontoDescarteDto salvarPontoDeDescarte(PontoDescarteDto pontoDescarteDto){
        PontosDescarte novoPontosDescarte = new PontosDescarte();
        novoPontosDescarte.setLatitudePonto(pontoDescarteDto.getLatitudePonto());
        novoPontosDescarte.setLongitudePonto(pontoDescarteDto.getLongitudePonto());
        novoPontosDescarte.setMarcadorPonto(pontoDescarteDto.getMarcadorPonto());

        PontosDescarte pontoSalvo = pontosDescarteRepository.save(novoPontosDescarte);
        PontoDescarteDto pontoSalvoDto = new PontoDescarteDto();

        pontoSalvoDto.setLatitudePonto(pontoSalvo.getLatitudePonto());
        pontoSalvoDto.setLongitudePonto(pontoSalvo.getLongitudePonto());
        pontoSalvoDto.setMarcadorPonto(pontoSalvo.getMarcadorPonto());

        return pontoSalvoDto;
    }
}
