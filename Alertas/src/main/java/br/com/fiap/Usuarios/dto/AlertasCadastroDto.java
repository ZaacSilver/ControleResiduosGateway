package br.com.fiap.Usuarios.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AlertasCadastroDto(

        Long idAlertas,
        Long idSensor,

        @NotBlank(message = "Informe o Tipo de Alerta!")
        String tipoAlerta,

        @NotNull(message = "Informe a Data!")
        LocalDateTime dataHora,

        @NotBlank(message = "Informe a mensagem desejada para o Alerta!")
        String mensagemAlerta

) {

}