package br.com.fiap.Alertas.repository;
import br.com.fiap.Alertas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    // o Long é para identificar o Objeto Identificador do usuario ID

    UserDetails findByEmail(String email); //temos que usar o findByEmail padrao JPA

    Optional<Usuario> findByNome(String nome);

    boolean existsByEmail(String email);
}
