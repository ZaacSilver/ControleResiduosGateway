package br.com.fiap.Localizacoes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocalizacoesCadastroDto(

        Long idLocalizacao,


        @NotNull(message = "É Obrigatório inserir a Latitude!")
        Double longitude,
        @NotNull(message = "É Obrigatório inserir a Longitude!")
        Double latitude,

        @NotBlank(message = "É Obrigatório inserir a Localidade!")
        String nomeLocalizacao
){

}
