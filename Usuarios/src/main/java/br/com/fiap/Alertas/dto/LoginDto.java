package br.com.fiap.Alertas.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(

        @NotBlank(message = "O e-mail do usuario é obrigatório")
        @Email(message = "O e-mail do usuario não é valido")
        String email,

        @NotBlank(message = "a senha do usuario é obrigatório")
        @Size(min = 6, max = 20, message = " A senha deve conter 6 e 20 caracteres")
        String senha
) {

}