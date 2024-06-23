package com.conectavel.projetc.repository;

import com.conectavel.projetc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT idUsuario from Usuario WHERE emailUsuario = :email AND senhaUsuario = :senha")
    Long findIdByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

    Usuario findByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.tipoPerfil.idTipoPerfil = :tipo")
    long countByProfileType(@Param("tipo") long tipoPerfil);


}
