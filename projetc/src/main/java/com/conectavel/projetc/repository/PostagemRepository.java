package com.conectavel.projetc.repository;

import com.conectavel.projetc.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
