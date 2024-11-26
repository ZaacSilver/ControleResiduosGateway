package br.com.fiap.Alertas.dto;
import br.com.fiap.Alertas.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto<role>(
//regras de validação usar o @Valid no Controller Auth
        Long usuarioId,

        @NotBlank(message = "É Obrigatório inserir o nome")
        String nome,

        @NotBlank(message = "É Obrigatorio inserir um e-mail")
        @Email(message = "O e-mail está com o formato inválido!")
        String email,

        @NotBlank(message = "É Obrigatório inserir uma senha")
        @Size(min = 6, max = 10, message = " A senha deve conter de 6 a 10 caracteres")
        String senha,
        UsuarioRole role
) {

}