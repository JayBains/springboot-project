package com.example.pokemon_generator.Services;

import com.example.pokemon_generator.Models.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PokemonService {

    RestTemplate restTemplate = new RestTemplate();

    public Pokemon getPokemonByName(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        // Get the full response
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        Map pokemonData = responseEntity.getBody();

        // Extract only what we need
        Pokemon simplePokemon = new Pokemon();
        simplePokemon.setName((String) pokemonData.get("name"));

        // Extract the front_default sprite URL
        Map<String, Object> sprites = (Map<String, Object>) pokemonData.get("sprites");
        simplePokemon.setSpriteUrl((String) sprites.get("front_default"));

        return simplePokemon;
    }
}