package br.com.compasso.avalicao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class AvalicaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvalicaoApplication.class, args);
	}

}
