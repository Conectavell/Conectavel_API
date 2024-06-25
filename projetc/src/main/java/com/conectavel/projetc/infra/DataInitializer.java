package com.conectavel.projetc.infra;


import com.conectavel.projetc.model.Habilidades;
import com.conectavel.projetc.model.TipoPerfil;
import com.conectavel.projetc.repository.HabilidadesRepository;
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

    @Bean
    public CommandLineRunner initDatabaseTwo(HabilidadesRepository habilidadesRepository){
        return args -> {
            if(habilidadesRepository.count() == 0){
                Habilidades habilidadeUm = new Habilidades("\uD83C\uDFAE Manutenção de vídeo games", "Manutenção em vídeo games : PS4 ou Xbox.");
                Habilidades habilidadeDois = new Habilidades("\uD83D\uDCF1 Manutenção de aparelhos telefônicos", "Manuteção de celulares e telefones.");
                Habilidades habilidadeTres = new Habilidades("\uD83D\uDCFA Manutenção de televisores", "Manutenção de Televisões.");
                Habilidades habilidadeQuatro = new Habilidades("\uD83C\uDF9B\uFE0F Manutenção de eletrodomésticos", "Manutenção de aparelhos de casa.");
                Habilidades habilidadeCinco = new Habilidades("\uD83D\uDDA5\uFE0F Manutenção de computadores", "Manutenção de computadores e notebooks.");

                Habilidades[] Itens = {habilidadeUm, habilidadeDois, habilidadeTres, habilidadeQuatro, habilidadeCinco};

                for(Habilidades i: Itens){
                    habilidadesRepository.save(i);
                }
            }
        };
    }
}
