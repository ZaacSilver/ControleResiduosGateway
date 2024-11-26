package br.com.fiap.Alertas.config.security;




import br.com.fiap.Alertas.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class VerificarToken extends OncePerRequestFilter {  //estamos dizendo para verificar apenas umas vez, deixar que fique verificando diversas vezes podemos ter perda de desempenho

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request
            ,HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization"); //Bearer jdhaovdysuivgçlajdc é como o servidor recebe o token, abaixo eliminamos o "BEARER" e seus espaços e enviamos apenas o algoritmo da senha
        String token = "";

        if (authorizationHeader == null){
            token = null;
        } else {
            token = authorizationHeader.replace("Bearer","").trim();
            String login = tokenService.validarToken(token);
            UserDetails usuario = usuarioRepository.findByEmail(login);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            usuario,
                            null,
                            usuario.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request,response);



    }

}

