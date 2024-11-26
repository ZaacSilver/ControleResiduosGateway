package br.com.fiap.Localizacoes.dto;

import br.com.fiap.Localizacoes.model.Localizacoes;

public record LocalizacoesExibicaoDto(
        Long idLocalizacao,
        Double logitude,
        Double latitude,
        String nomeLocalizacao

) {
    public LocalizacoesExibicaoDto (Localizacoes localizacoes){
        this(
                localizacoes.getIdLocalizacao(),
                localizacoes.getLatitude(),
                localizacoes.getLongitude(),
                localizacoes.getNomeLocalizacao()
        );
    }
}