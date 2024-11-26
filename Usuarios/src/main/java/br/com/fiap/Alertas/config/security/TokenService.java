package br.com.fiap.Alertas.config.security;


import br.com.fiap.Alertas.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

//GERANDO TOKEN...

@Service
public class TokenService {

    @Value("${minha.chave.secreta}")
    private String PalavraSecreta;

    public String gerarToken(Usuario usuario){
        try{ // o TRY serve para gerar uma excessao exception, pois pode gerar um erro
            Algorithm algorithm = Algorithm.HMAC256(PalavraSecreta);
            String token = JWT
                    .create()
                    .withIssuer("usuarios")                 //<identificador de quem emitiu o TOKEN
                    .withSubject(usuario.getEmail())        //<identifica o usuario, o nome do usuario.
                    .withExpiresAt(gerarDataDeExpiracao())  //<por quanto tempo dura o Token ?
                    .sign(algorithm);                       //<assinamos o token, aplicar a criptografia

            return token;

        } catch (JWTCreationException erro){//criando uma excessao para o criar token
            throw new RuntimeException("Não foi possivel gerar o token!");
        }

    }
    public Instant gerarDataDeExpiracao(){
        return LocalDateTime.now()
                .plusHours(2)                           //acrescentamos horas ao tempo atual, ou seja, se agora for 10hrs, será valido o token de 10hrs até 12h
                .toInstant(ZoneOffset.of(("-03:00")));//aqui informamos que estamos a -3horas de Greenwich, Londres(para o nosso tempo dar certo conforme o horario de brasilia)
    }

    public String validarToken (String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(PalavraSecreta);
            return JWT.require(algorithm)
                    .withIssuer("usuarios")
                    .build()        //aqui solicitamos para quele criar o algoritmo
                    .verify(token)
                    .getSubject();  // para pegar o obejto do usuario


        } catch (JWTVerificationException erro){
            return "";
        }
    }

}
