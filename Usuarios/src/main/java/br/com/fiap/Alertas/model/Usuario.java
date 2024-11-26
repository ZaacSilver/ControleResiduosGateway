package br.com.fiap.Alertas.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@NoArgsConstructor // a JPA PRECISE DESSE METODO SEM ARGUMENTOS
@AllArgsConstructor// ESSE AQUI TAMBÉM (JPA)
@EqualsAndHashCode// É IMPORTANTE PARA O FRAMEWORK PARA CRIAÇÃO DE OBJETOS


public class Usuario implements UserDetails { //UserDetails  é uma interface, usamos para o Spring Security, devemos implementar o metodo passando o mouse em cima do implements para definir as permissões

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIOS"

    )
    @SequenceGenerator(name = "SEQ_USUARIOS",
            sequenceName = "SEQ_USUARIOS",
            allocationSize = 1)
    private Long usuarioId;

    private String nome;
    private String email;
    private String senha;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    // (aqui passamos o tipo de dados que iremos pegar de UsuarioRole, no caso é ADMIN ou User, por isso STRING. )
    private UsuarioRole role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsuarioRole.ADMIN) {   //SE O USUARIO FOR ADMIN, ENTÃO TUDO LIBERADO SENÃO É APENAS USUARIO
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );

        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }

    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() { // aqui devemos usar o e-mail, serve para identificar o usuario no sistema (lembre-se definimos o e-mail como unico)
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

