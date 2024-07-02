package com.conectavel.projetc.repository;

import com.conectavel.projetc.dto.FiltrarDto;
import com.conectavel.projetc.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT idUsuario from Usuario WHERE emailUsuario = :email AND senhaUsuario = :senha")
    Long findIdByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

    Usuario findByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.tipoPerfil.idTipoPerfil = :tipo")
    long countByProfileType(@Param("tipo") long tipoPerfil);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET emailUsuario = :email WHERE u.idUsuario = :id")
    void setEmailUsuarioById(@Param("email") String email, @Param("id") Long tipo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET sobrenomeUsuario = :sobrenome WHERE u.idUsuario = :id")
    void setSobrenomeUsuarioById(@Param("sobrenome") String sobrenome, @Param("id") Long tipo);
/////

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET senhaUsuario = :senha WHERE u.idUsuario = :id")
    void setSenhaUsuarioById(@Param("senha") String senha, @Param("id") Long tipo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET experienciaUsuario = :experiencia WHERE u.idUsuario = :id")
    void setExperienciaUsuarioById(@Param("experiencia") String experiencia, @Param("id") Long tipo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET fotoPerfilPath = :foto WHERE u.idUsuario = :id")
    void setFotoUsuarioById(@Param("foto") String foto, @Param("id") Long tipo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET sobreUsuario = :sobre WHERE u.idUsuario = :id")
    void setSobreUsuarioById(@Param("sobre") String sobre, @Param("id") Long tipo);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET habilidadeUsuario = :habilidade WHERE u.idUsuario = :id")
    void setHabilidadeUsuarioById(@Param("habilidade") String habilidade, @Param("id") Long tipo);


    @Modifying
    @Transactional
    @Query("UPDATE Usuario u set nomeUsuario = :nome WHERE u.idUsuario = :id")
    void setNomeUsuarioById(@Param("nome") String nome, @Param("id") Long id);


    @Query("SELECT new com.conectavel.projetc.dto.FiltrarDto(u.idUsuario, u.nomeUsuario, u.fotoPerfilPath) FROM Usuario u JOIN u.habilidades h WHERE h.idHabilidade = :valorHabilidade")
    List<FiltrarDto> filtraPrestadorDeServico(@Param("valorHabilidade") Long valorHabilidade);
}
