package br.com.fiap.Usuarios.dto;

import br.com.fiap.Usuarios.model.Alertas;

import java.time.LocalDateTime;

public record AlertasExibicaoDto(

        Long idAlertas,
        Long idSensor,
        String tipoAlerta,
        LocalDateTime dataHora,
        String mensagemAlerta


) {
    public AlertasExibicaoDto(Alertas alertas){
        this(
                alertas.getIdAlerta(),
                alertas.getIdSensor(),
                alertas.getTipoAlerta(),
                alertas.getDataHora(),
                alertas.getMensagemAlerta()
        );
    }
}
