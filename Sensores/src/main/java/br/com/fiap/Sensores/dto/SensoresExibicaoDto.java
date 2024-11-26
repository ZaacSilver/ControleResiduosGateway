package br.com.fiap.Sensores.dto;
import br.com.fiap.Sensores.model.Sensores;


public record SensoresExibicaoDto(

        Long idSensor,
        String nome,
        String tipo


) {
    public SensoresExibicaoDto (Sensores sensores){
        this(
                sensores.getIdSensor(),
                sensores.getNome(),
                sensores.getTipo()

        );
    }
}