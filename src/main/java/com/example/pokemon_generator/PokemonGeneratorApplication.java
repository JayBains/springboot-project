package com.example.pokemon_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokemonGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonGeneratorApplication.class, args);
	}

}
