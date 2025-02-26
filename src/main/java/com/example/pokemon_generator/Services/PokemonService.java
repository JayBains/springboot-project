package com.example.pokemon_generator.Services;

import com.example.pokemon_generator.Models.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    RestTemplate restTemplate = new RestTemplate();

    public Pokemon getPokemonByName(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        return restTemplate.getForObject(url, Pokemon.class);
    }
}
