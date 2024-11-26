package br.com.fiap.Alertas.dto;


import br.com.fiap.Alertas.model.Usuario;
import br.com.fiap.Alertas.model.UsuarioRole;

public record UsuarioExibicaoDto(
        //USUARIO DTO DEFINIMOS O QUE O USUARIO VE NA TELA OU NO POSTMAN
        Long usuarioId,
        String nome,
        String email,
        UsuarioRole role

) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()

        );
    }

}


