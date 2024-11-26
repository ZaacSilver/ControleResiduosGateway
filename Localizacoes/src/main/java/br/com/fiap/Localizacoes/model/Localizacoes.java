package br.com.fiap.Localizacoes.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "localizacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ID"
    )
    @SequenceGenerator(name = "SEQ_ID",
            sequenceName = "SEQ_ID",
            allocationSize = 1)

    private Long idLocalizacao;
    private Double latitude;
    private Double longitude;
    private String nomeLocalizacao;

    public Long getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNomeLocalizacao() {
        return nomeLocalizacao;
    }

    public void setNomeLocalizacao(String nomeLocalizacao) {
        this.nomeLocalizacao = nomeLocalizacao;
    }





}
