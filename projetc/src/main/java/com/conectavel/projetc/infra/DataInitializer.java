package com.conectavel.projetc.infra;


import com.conectavel.projetc.model.TipoPerfil;
import com.conectavel.projetc.repository.TipoPerfilRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(TipoPerfilRepository tipoPerfilRepository) {
        return args -> {
            if(tipoPerfilRepository.count() == 0){
                TipoPerfil cliente = new TipoPerfil("Cliente", "Perfil Cliente");
                TipoPerfil profissional = new TipoPerfil("Profissional", "Perfil Profissional");
                TipoPerfil admin = new TipoPerfil("Admin", "Perfil Admin");


                tipoPerfilRepository.save(cliente);
                tipoPerfilRepository.save(profissional);
                tipoPerfilRepository.save(admin);
            }
        };
    }
}
