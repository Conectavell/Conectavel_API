package com.conectavel.projetc.service;

import com.conectavel.projetc.dto.PostagemDto;
import com.conectavel.projetc.model.Postagem;
import com.conectavel.projetc.model.Usuario;
import com.conectavel.projetc.repository.PostagemRepository;
import com.conectavel.projetc.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postagemRepository){
        this.postagemRepository = postagemRepository;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public PostagemDto salvarPostagem(PostagemDto postagemDto) {
        Usuario usuario = usuarioRepository.findById(postagemDto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Postagem novaPostagem = new Postagem();
        novaPostagem.setFotoPostagem(postagemDto.getFotoPostagem());
        novaPostagem.setTextoPostagem(postagemDto.getTextoPostagem());
        novaPostagem.setUsuario(usuario);

        Postagem postagemSalva = postagemRepository.save(novaPostagem);

        postagemDto.setIdPostagem(postagemSalva.getIdPostagem());
        return postagemDto;
    }

    public void deletarPorId(Long id){
        postagemRepository.deleteById(id);
    }


}
