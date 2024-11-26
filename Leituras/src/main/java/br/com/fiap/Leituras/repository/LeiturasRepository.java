package br.com.fiap.Leituras.repository;
import br.com.fiap.Leituras.model.Leituras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LeiturasRepository extends JpaRepository<Leituras, Long> {


    Optional<Leituras> findByValor(Double valor);

    @Query("SELECT l FROM Leituras l WHERE l.dataHora BETWEEN :dataInicial AND :dataFinal")
    List<Leituras> listarLeituras(
            @Param("dataInicial")LocalDateTime dataInicial,
            @Param("dataFinal")LocalDateTime dataFinal);

}
