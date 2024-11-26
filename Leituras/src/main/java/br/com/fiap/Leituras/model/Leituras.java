package br.com.fiap.Leituras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "leituras")
@NoArgsConstructor
@AllArgsConstructor
public class Leituras {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_LEITURAS"
    )
    @SequenceGenerator(name = "SEQ_LEITURAS"
            , sequenceName = "SEQ_LEITURAS",
            allocationSize = 1)
    @Column(name = "id_leitura")
    private Long idLeitura;

    private Long idSensor;
    private Double valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leituras leituras = (Leituras) o;
        return Objects.equals(idLeitura, leituras.idLeitura) && Objects.equals(idSensor, leituras.idSensor) && Objects.equals(valor, leituras.valor) && Objects.equals(dataHora, leituras.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLeitura, idSensor, valor, dataHora);
    }

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public Long getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Long idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }


}
