package br.com.fiap.Alertas.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private VerificarToken verificarToken;

    @Bean //aqui dizemos a spring que o objeto deve ser gerenciado por ele
    public SecurityFilterChain filtrarCadeiaDeSeguranca
            (HttpSecurity httpSecurity) throws Exception {  //aqui retorna uma cadeia de seguranca

        return httpSecurity.csrf(csrf -> csrf.disable()) // aqui desabilitamos o recurso de segurança(impede falsificação de solicitação entre sites)
                .sessionManagement(session -> session.sessionCreationPolicy //POLITICA DE CRIAÇÃO DE SERGURANÇA
                        (SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()  // permitem tudo
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()    // aqui permite para todos qualquer chamada para o endereço auth/login

                        .requestMatchers(HttpMethod.PUT,"/api/localizacao").hasAnyRole("ADMIN", "USER")         //Aqui decidimos quem poderá usar as informações um Usuario tipo: USER ou um ADMINISTRADOR
                        .requestMatchers(HttpMethod.GET,"/api//local/{nomeLocalizacao}").hasAnyRole("ADMIN", "USER")   //Aqui decidimos quem poderá usar as informações um Usuario tipo: USER ou um ADMINISTRADOR
                        .requestMatchers(HttpMethod.POST,"/api/localizacao").hasAnyRole("ADMIN", "USER")        //Aqui decidimos quem poderá usar as informações um Usuario tipo: USER ou um ADMINISTRADOR
                        .requestMatchers(HttpMethod.DELETE,"/api/localizacao/{idLocalizacao}").hasRole("ADMIN")              //Aqui decidimos quem poderá usar as informações um Usuario tipo: USER ou um ADMINISTRADOR

                        .requestMatchers(HttpMethod.PUT,"/api/sensor").hasAnyRole("ADMIN", "USER")  //Aqui decidimos quem poderá usar as informações de um Usuario tipo: USER ou ADMINISTRADOR
                        .requestMatchers(HttpMethod.GET,"/api/sensor/{nome}").hasAnyRole("ADMIN", "USER")  //Aqui decidimos quem poderá usar as informações de um Usuario tipo: USER ou ADMINISTRADOR
                        .requestMatchers(HttpMethod.POST,"/api/sensor").hasAnyRole("ADMIN", "USER") //Aqui decidimos quem poderá usar as informações de um Usuario tipo: USER ou ADMINISTRADOR
                        .requestMatchers(HttpMethod.DELETE,"/api/sensor/{idSensor}").hasRole("ADMIN")       //Aqui decidimos quem poderá usar as informações de um Usuario tipo: USER ou ADMINISTRADOR

                        .requestMatchers(HttpMethod.PUT,"/api/leitura").hasAnyRole("ADMIN", "USER") //FUTURAMENTE SERA IMPLEMENTADO, DEPENDENDO DA NECESSIDADE
                        .requestMatchers(HttpMethod.GET, "/api/leitura").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.POST, "/api/leitura").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/leitura").hasRole("ADMIN")//FUTURAMENTE SERA IMPLEMENTADO, DEPENDENDO DA NECESSIDADE

                        .requestMatchers(HttpMethod.POST, "/api/alertas").hasRole("ADMIN")//NO MOMENTO SÓ EXISTE ESSA NECESSIDADE Limitando O INSERT APENAS PARA O ADMIN
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(verificarToken,
                        UsernamePasswordAuthenticationFilter.class)//adicionando um filtro para saber se o usuario é ADMIN ou USER
                .build();
    }

    @Bean  //aqui dizemos a spring que o objeto deve ser gerenciado por ele
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){ // retorna um objeto que sabe como criptografar a senha pra gente
        return new BCryptPasswordEncoder();
    }
}

