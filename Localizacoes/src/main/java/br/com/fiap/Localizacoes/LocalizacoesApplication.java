package br.com.fiap.Localizacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //serviço tipo client do Eureka

public class LocalizacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalizacoesApplication.class, args);
	}

}
