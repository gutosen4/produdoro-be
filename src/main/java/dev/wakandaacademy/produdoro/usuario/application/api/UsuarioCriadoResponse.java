package dev.wakandaacademy.produdoro.usuario.application.api;

import dev.wakandaacademy.produdoro.usuario.domain.ConfiguracaoUsuario;
import dev.wakandaacademy.produdoro.usuario.domain.StatusUsuario;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Value
public class UsuarioCriadoResponse {
    private final UUID IdUsuario;
    private final String email;
    private final ConfiguracaoUsuarioResponse configuracao;
    private final StatusUsuario status;
    private final Integer quantidadePomodorosPausaCurta = 0;

    public UsuarioCriadoResponse(Usuario usuario) {
        IdUsuario = usuario.getIdUsuario();
        this.email = usuario.getEmail();
        this.configuracao = new ConfiguracaoUsuarioResponse(usuario.getConfiguracao());
        this.status = usuario.getStatus();
    }
}
