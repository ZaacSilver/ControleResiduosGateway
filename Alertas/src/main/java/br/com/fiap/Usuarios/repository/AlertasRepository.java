package br.com.fiap.Usuarios.repository;

import br.com.fiap.Usuarios.model.Alertas;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertasRepository extends JpaRepository<Alertas, Long> {

    Optional<Alertas>findByTipoAlerta(String tipoAlerta);
}
