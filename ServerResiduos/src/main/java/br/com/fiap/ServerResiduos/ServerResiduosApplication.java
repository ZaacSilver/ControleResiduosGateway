package br.com.fiap.ServerResiduos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //habilitando um servidor eureka
public class ServerResiduosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerResiduosApplication.class, args);
	}

}
