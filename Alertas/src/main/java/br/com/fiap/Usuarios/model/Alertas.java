package br.com.fiap.Usuarios.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "alertas")
@NoArgsConstructor
@AllArgsConstructor
public class Alertas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALERTAS"
    )

    @SequenceGenerator(name = "SEQ_ALERTAS",
            sequenceName = "SEQ_ALERTAS",
            allocationSize = 1
    )
    @Column(name = "id_alertas")
    private Long idAlerta;

    private Long idSensor;

    private String tipoAlerta;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    private String mensagemAlerta;


    @Override
    public int hashCode() {
        return Objects.hash(idAlerta, idSensor, tipoAlerta, dataHora, mensagemAlerta);
    }


    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagemAlerta() {
        return mensagemAlerta;
    }

    public void setMensagemAlerta(String mensagemAlerta) {
        this.mensagemAlerta = mensagemAlerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alertas alertas = (Alertas) o;
        return Objects.equals(idAlerta, alertas.idAlerta) && Objects.equals(idSensor, alertas.idSensor) && Objects.equals(tipoAlerta, alertas.tipoAlerta) && Objects.equals(dataHora, alertas.dataHora) && Objects.equals(mensagemAlerta, alertas.mensagemAlerta);
    }


}
