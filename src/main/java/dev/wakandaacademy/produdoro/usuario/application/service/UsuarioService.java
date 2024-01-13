package dev.wakandaacademy.produdoro.usuario.application.service;

import dev.wakandaacademy.produdoro.pomodoro.domain.ConfiguracaoPadrao;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioNovoRequest;
import dev.wakandaacademy.produdoro.usuario.domain.ConfiguracaoUsuario;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UsuarioService implements UsuarioApplicatonService {
    @Override
    public UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[start] UsuarioService - criadoNovoUsuario");
        ConfiguracaoPadrao configuracaoPadrao = getConfiguracaoPadrao();
        Usuario usuario = new Usuario(usuarioNovo, configuracaoPadrao);
        log.info("[finish] UsuarioService - criadoNovoUsuario");
        return new UsuarioCriadoResponse(usuario);
    }

    private static ConfiguracaoPadrao getConfiguracaoPadrao() {
        ConfiguracaoPadrao configuracaoPadrao = ConfiguracaoPadrao.builder()
                .tempoMinutosFoco(25)
                .tempoMinutosPausaCurta(5)
                .tempoMinutosPausaLonga(15)
                .repeticoesMinutosPausaLonga(3)
                .build();
        return configuracaoPadrao;
    }
}
