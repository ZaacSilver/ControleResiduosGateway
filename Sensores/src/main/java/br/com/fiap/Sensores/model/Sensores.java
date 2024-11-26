package br.com.fiap.Sensores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "sensores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Sensores {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ID_SENSORES"
    )

    @SequenceGenerator(name = "ID_SENSORES",
            sequenceName = "ID_SENSORES",
            allocationSize = 1
    )
    @Column(name = "id_sensor")

    private Long idSensor;

    private String nome;
    private String tipo;


    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}